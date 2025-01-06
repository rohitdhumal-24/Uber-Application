package com.rohit.project.uber.uberApp.utills;

import com.rohit.project.uber.uberApp.dto.PointDto;
import org.locationtech.jts.geom.*;

public class GeometryUtil {

    public static Point createPoint(PointDto pointDto){
        GeometryFactory geometryFactory= new GeometryFactory(new PrecisionModel(),4326); // For earth Co-ordinates
        Coordinate coordinate = new Coordinate(pointDto.getCoordinates()[0],
                pointDto.getCoordinates()[1]
        );
        return geometryFactory.createPoint(coordinate);
    }
}
