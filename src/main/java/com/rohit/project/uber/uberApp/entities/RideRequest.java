package com.rohit.project.uber.uberApp.entities;

import com.rohit.project.uber.uberApp.entities.enums.PaymentMethod;
import com.rohit.project.uber.uberApp.entities.enums.RideRequestStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(
        indexes = {
                @Index(name="idx_rider_rider",columnList = "rider_id")
        }
)
public class RideRequest {
//One driver has many ride request as he complete one the next one & it store in the database.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="Geometry(Point, 4326)")
    private Point pickupLocation;

    @Column(columnDefinition="Geometry(Point, 4326)")
    private Point dropOffLocation;

    @CreationTimestamp
    private LocalDateTime requestedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rider rider;    // One rifer have choice of multiple Ride Requests options.

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private RideRequestStatus rideRequestStatus;

    private Double fare;

}
