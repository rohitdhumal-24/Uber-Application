package com.rohit.project.uber.uberApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {
    private UserDto user; //c

    private Double rating;

    private Long id;

    private String vehicleId;

    private boolean available;

}
