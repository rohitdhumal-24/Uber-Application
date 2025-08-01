package com.rohit.project.uber.uberApp.services.Impl;

import com.rohit.project.uber.uberApp.services.DistanceService;
import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;


@Service
public class DistanceServiceOSRMImpl implements DistanceService {

    private static final String OSRM_API_BASE_URL = "https://router.project-osrm.org/route/v1/driving/";
    // OSRM api

    @Override
    public double calculateDistance(Point src, Point dest) {
     // Calling the Third party api for fetching the distance using  RestClient and "mapping Object"
    try {
        String uri = src.getX()+","+src.getY()+";"+dest.getX()+","+dest.getY();
        OSRMResponseDto responseDto = RestClient.builder()
                .baseUrl(OSRM_API_BASE_URL)
                .build()
                .get()
//              .uri("{},{},{},{}", src.getX(), src.getY(), dest.getX(), dest.getY())
                .uri(uri)
                .retrieve()
                .body(OSRMResponseDto.class);
        return responseDto.getRoutes().get(0).getDistance() / 1000.0;   // convert into meter
        //getX---> latitude and getY--->longitude
    }
    catch(Exception e){
       throw new RuntimeException("Error getting the Data from OSRM"+e.getMessage());
      }
    }
}

@Data
class OSRMResponseDto{
 private List<OSRMRoute> routes;
}
@Data
class OSRMRoute{
    private Double distance;
}