package com.rohit.project.uber.uberApp.services;

import com.rohit.project.uber.uberApp.dto.DriverDto;
import com.rohit.project.uber.uberApp.dto.RiderDto;
import com.rohit.project.uber.uberApp.entities.Driver;
import com.rohit.project.uber.uberApp.entities.Ride;
import com.rohit.project.uber.uberApp.entities.Rider;

public interface RatingService {

    DriverDto rateDriver(Ride ride, Integer rating);

    RiderDto rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);

}
