package com.rohit.project.uber.uberApp.dto;

import com.rohit.project.uber.uberApp.entities.Driver;
import com.rohit.project.uber.uberApp.entities.Rider;
import com.rohit.project.uber.uberApp.entities.enums.PaymentMethod;
import com.rohit.project.uber.uberApp.entities.enums.RideRequestStatus;
import com.rohit.project.uber.uberApp.entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequestDto {

    private Long id;

    private PointDto pickupLocation;

    private PointDto dropOffLocation;

    private LocalDateTime requestedTime;

    private RiderDto rider;
    private Double fare;

//    private DriverDto driver;

    private PaymentMethod paymentMethod;

    private RideRequestStatus rideRequestStatus;
}
