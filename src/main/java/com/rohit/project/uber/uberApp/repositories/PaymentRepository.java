package com.rohit.project.uber.uberApp.repositories;

import com.rohit.project.uber.uberApp.entities.Payment;
import com.rohit.project.uber.uberApp.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

    Optional<Payment> findByRide(Ride ride);
}
