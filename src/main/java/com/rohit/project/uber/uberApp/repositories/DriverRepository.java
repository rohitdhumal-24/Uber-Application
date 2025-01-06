package com.rohit.project.uber.uberApp.repositories;

import com.rohit.project.uber.uberApp.entities.Driver;
import com.rohit.project.uber.uberApp.entities.User;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//ST_Distance(point1,point2) ---> Calculate distance between two points
//ST_DWithin(point1,10000)----> distance within 10km range.

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
   @Query(value = "SELECT d.*, ST_Distance(d.current_location, :pickupLocation) AS distance " +
           "FROM driver d " +
           "WHERE d.available = true AND ST_DWithin(d.current_location, :pickupLocation, 10000) " +
           "ORDER BY distance " +
           "LIMIT 10", nativeQuery = true)
   List<Driver> findTenNearestDrivers(Point pickupLocation);

   @Query(value = "SELECT d.* " +
           "FROM driver d " +
           "WHERE d.available = true AND ST_DWithin(d.current_location, :pickupLocation, 15000) " +
           "ORDER BY d.rating DESC " +
           "LIMIT 10", nativeQuery = true)
   List<Driver> findTenNearbyTopRatedDrivers(Point pickupLocation);

    Optional<Driver> findByUser(User user);
// 10 most rated driver within 15km range in descendingOrder are sorted by implementing Query

}
