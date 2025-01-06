package com.rohit.project.uber.uberApp.services;

import com.rohit.project.uber.uberApp.dto.DriverDto;
import com.rohit.project.uber.uberApp.dto.SignupDto;
import com.rohit.project.uber.uberApp.dto.UserDto;

// Authenticated information like login, signup,password etc
public interface AuthService {

    String[] login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userId,String vehicleId);

    String refreshToken(String refreshToken);
}
