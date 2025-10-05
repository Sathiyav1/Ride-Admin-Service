package com.chalow.rideshare.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.chalow.rideshare")
public class RideAdminServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RideAdminServiceApplication.class, args);
    }
}
