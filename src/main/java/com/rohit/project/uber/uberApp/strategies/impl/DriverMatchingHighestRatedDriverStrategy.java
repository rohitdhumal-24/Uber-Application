package com.rohit.project.uber.uberApp.strategies.impl;

import com.rohit.project.uber.uberApp.dto.RideRequestDto;
import com.rohit.project.uber.uberApp.entities.Driver;
import com.rohit.project.uber.uberApp.entities.RideRequest;
import com.rohit.project.uber.uberApp.repositories.DriverRepository;
import com.rohit.project.uber.uberApp.strategies.DriverMatchingStrategy;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearbyTopRatedDrivers(rideRequest.getPickupLocation());
    }
}
