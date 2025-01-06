package com.rohit.project.uber.uberApp.dto;
// Dto ---> data transfer Object along the Different.
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupDto {

        @Email(message = "Invalid email format")
        @NotBlank(message = "Email is mandatory")
        private String email;

        @NotBlank(message = "Password is mandatory")
        @Size(min = 8, message = "Password must be at least 8 characters long")
        private String password;

        @NotBlank(message = "First name is mandatory")
        private String name;

    }

