package com.chalow.rideshare.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Driver {
    private Long id;
    private User user;
    private String licenseNumber;
    private String licenseState;
    private LocalDate licenseExpiryDate;
    private String insurancePolicyNumber;
    private LocalDate insuranceExpiryDate;
    private List<Vehicle> vehicles;
    private List<DocumentVerification> documentVerifications;
    private LocalDateTime createdAt;

    public Long getId() { return id; }
    public User getUser() { return user; }
    public String getLicenseNumber() { return licenseNumber; }
    public String getLicenseState() { return licenseState; }
    public LocalDate getLicenseExpiryDate() { return licenseExpiryDate; }
    public String getInsurancePolicyNumber() { return insurancePolicyNumber; }
    public LocalDate getInsuranceExpiryDate() { return insuranceExpiryDate; }
    public List<Vehicle> getVehicles() { return vehicles; }
    public List<DocumentVerification> getDocumentVerifications() { return documentVerifications; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
