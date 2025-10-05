package com.chalow.rideshare.dto;

import java.time.LocalDateTime;

public class DriverDTO {
    public static class DriverPendingApprovalResponse {
        private Long id;
        private String driverName;
        private String email;
        private LocalDateTime createdAt;

        public DriverPendingApprovalResponse() {}

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getDriverName() { return driverName; }
        public void setDriverName(String driverName) { this.driverName = driverName; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public LocalDateTime getCreatedAt() { return createdAt; }
        public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    }

    public static class DriverApprovalResponse {
        private String status;
        private String message;
        private Long driverId;
        private LocalDateTime approvedAt;

        public DriverApprovalResponse() {}

        public DriverApprovalResponse(String status, String message, Long driverId, LocalDateTime approvedAt) {
            this.status = status; this.message = message; this.driverId = driverId; this.approvedAt = approvedAt;
        }

        public String getStatus() { return status; }
        public String getMessage() { return message; }
        public Long getDriverId() { return driverId; }
        public LocalDateTime getApprovedAt() { return approvedAt; }
    }
}
