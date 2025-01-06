package com.rohit.project.uber.uberApp.repositories;

import com.rohit.project.uber.uberApp.entities.Rider;
import com.rohit.project.uber.uberApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider,Long> {
    Optional<Rider> findByUser(User user);
}

