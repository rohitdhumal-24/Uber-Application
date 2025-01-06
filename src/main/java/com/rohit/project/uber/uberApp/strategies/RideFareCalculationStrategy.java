package com.rohit.project.uber.uberApp.strategies;

import com.rohit.project.uber.uberApp.dto.RideRequestDto;
import com.rohit.project.uber.uberApp.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER=10; // this multiplier are different for cityWise also timeWise

    double calculateFare(RideRequest rideRequest);
}
