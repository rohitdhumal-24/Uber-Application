package com.rohit.project.uber.uberApp.repositories;

import com.rohit.project.uber.uberApp.entities.Driver;
import com.rohit.project.uber.uberApp.entities.Ride;
import com.rohit.project.uber.uberApp.entities.Rider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride,Long> {

    Page<Ride> findByDriver(Driver driver, Pageable pageRequest);

    Page<Ride> findByRider(Rider rider, Pageable pageRequest);

}
