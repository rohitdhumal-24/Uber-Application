package com.rohit.project.uber.uberApp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PointDto {

    private double[] coordinates;
    private String type="Point";  // belong to the GeoSpatial points

    public PointDto(double[] coordinates) {
        this.coordinates = coordinates;
    }
}
