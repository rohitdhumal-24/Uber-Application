package com.rohit.project.uber.uberApp.strategies;

import com.rohit.project.uber.uberApp.strategies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.rohit.project.uber.uberApp.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.rohit.project.uber.uberApp.strategies.impl.RideFareDefaultFareCalculationStrategy;
import com.rohit.project.uber.uberApp.strategies.impl.RideFareSurgePricingFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {
// Responsibilities of strategy manager to manage all the All the strategies

    private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
    private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
    private final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;
    private final RideFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;

 // If rider make expectations that the Driver must high rated otherwise nearest Driver
    public DriverMatchingStrategy driverMatchingStrategy(double riderRating){
        if(riderRating >= 4.8){
           return highestRatedDriverStrategy;
        }
        else{
            return nearestDriverStrategy;
        }
    }
    public RideFareCalculationStrategy rideFareCalculationStrategy(){
// suppose this Is PEAK Hours for driver 6PM TO 9PM
        LocalTime surgeStartTime = LocalTime.of(18,0);
        LocalTime surgeEndTime = LocalTime.of(21,0);
        LocalTime currentTime = LocalTime.now();

        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

        if(isSurgeTime){
            return surgePricingFareCalculationStrategy;
        }
        else{
            return defaultFareCalculationStrategy;
        }
    }
}

