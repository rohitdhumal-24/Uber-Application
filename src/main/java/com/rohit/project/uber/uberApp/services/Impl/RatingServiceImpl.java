package com.rohit.project.uber.uberApp.services.Impl;

import com.rohit.project.uber.uberApp.dto.DriverDto;
import com.rohit.project.uber.uberApp.dto.RiderDto;
import com.rohit.project.uber.uberApp.entities.Driver;
import com.rohit.project.uber.uberApp.entities.Rating;
import com.rohit.project.uber.uberApp.entities.Ride;
import com.rohit.project.uber.uberApp.entities.Rider;
import com.rohit.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.rohit.project.uber.uberApp.exceptions.RuntimeConflictException;
import com.rohit.project.uber.uberApp.repositories.DriverRepository;
import com.rohit.project.uber.uberApp.repositories.RatingRepository;
import com.rohit.project.uber.uberApp.repositories.RiderRepository;
import com.rohit.project.uber.uberApp.services.RatingService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

// As the ride is starting the object is formed ans as closed then User Have to Give Rating.
@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final DriverRepository driverRepository;
    private final RiderRepository riderRepository;
    private final ModelMapper modelMapper;

    @Override
    public DriverDto rateDriver(Ride ride, Integer rating) {
        Driver driver = ride.getDriver();
        Rating ratingObj = ratingRepository.findByRide(ride)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not found for the Ride with id : " + ride.getId()));

        if(ratingObj.getDriverRating() != null)
            throw new RuntimeConflictException("Driver has already been rated, cannot rate Again ");

        ratingObj.setDriverRating(rating);

        ratingRepository.save(ratingObj);

        Double newRating = ratingRepository.findByDriver(driver)
                .stream()
                .mapToDouble(Rating::getDriverRating)
                .average().orElse(0.0);
        driver.setRating(newRating);

        Driver savedDriver = driverRepository.save(driver);
        return modelMapper.map(savedDriver, DriverDto.class);
    }
        @Override
        public RiderDto rateRider(Ride ride, Integer rating){
            Rider rider = ride.getRider();
            Rating ratingObj = ratingRepository.findByRide(ride)
                    .orElseThrow(() -> new ResourceNotFoundException("Rating not found for the Ride with id : " + ride.getId()));

            if(ratingObj.getRiderRating() != null)
                throw new RuntimeConflictException("Rider has already been rated, cannot rate Again ");

            ratingObj.setRiderRating(rating);

            ratingRepository.save(ratingObj);

            Double newRating = ratingRepository.findByRider(rider)
                    .stream()
                    .mapToDouble(Rating::getRiderRating)
                    .average().orElse(0.0);
            rider.setRating(newRating);

            Rider savedRider = riderRepository.save(rider);
            return modelMapper.map(savedRider, RiderDto.class);
        }

        @Override
        public void createNewRating(Ride ride){
            Rating rating = Rating.builder()
                    .rider(ride.getRider())
                    .driver(ride.getDriver())
                    .ride(ride)
                    .build();
            ratingRepository.save(rating);
        }
    }