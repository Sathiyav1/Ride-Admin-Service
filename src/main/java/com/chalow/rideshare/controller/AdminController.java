package com.chalow.rideshare.controller;

import com.chalow.rideshare.dto.BlockedAddressDto;
import com.chalow.rideshare.dto.DriverDTO;
import com.chalow.rideshare.dto.PageResponse;
import com.chalow.rideshare.dto.UserDTO;
import com.chalow.rideshare.entity.*;
import com.chalow.rideshare.service.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    public static final String ERROR = "error";
    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
    private final DataArchivalService dataArchivalService;
    private final AddressBlockingService addressBlockingService;
    private final UserService userService;
    private final DriverService driverService;
    private final DocumentVerificationManagementService documentVerificationManagementService;
    private final KeycloakAdminService keycloakAdminService;

    public AdminController(
            DataArchivalService dataArchivalService,
            AddressBlockingService addressBlockingService,
            UserService userService,
            DriverService driverService,
            DocumentVerificationManagementService documentVerificationManagementService,
            KeycloakAdminService keycloakAdminService) {
        this.dataArchivalService = dataArchivalService;
        this.addressBlockingService = addressBlockingService;
        this.userService = userService;
        this.driverService = driverService;
        this.documentVerificationManagementService = documentVerificationManagementService;
        this.keycloakAdminService = keycloakAdminService;
    }

    private ResponseEntity<ErrorResponse> checkAdminAccess(Authentication authentication) {
        if (authentication == null || userService.isNotAdmin(authentication)) {
            LOG.warn(
                    "Unauthorized admin access attempt from user: {}",
                    authentication != null ? authentication.getName() : "anonymous");
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(new ErrorResponse("FORBIDDEN", "Admin access required"));
        }
        return null;
    }

    @GetMapping("/health/archival")
    public ResponseEntity<ArchivalHealthResponse> checkArchivalHealth(Authentication authentication) {
        ResponseEntity<?> accessCheck = checkAdminAccess(authentication);
        if (accessCheck != null) {
            return ResponseEntity.status(accessCheck.getStatusCode()).build();
        }

        try {
            DataArchivalService.ArchivalStats stats = dataArchivalService.getArchivalStats();

            ArchivalHealthResponse health = new ArchivalHealthResponse();
            health.status = "HEALTHY";
            health.activeRecords = stats.getActiveRideRequests() + stats.getActiveRideOffers() + stats.getActiveRides();
            health.archivedRecords = stats.getArchivedRideRequests() + stats.getArchivedRideOffers() + stats.getArchivedRides();
            health.scheduledForDeletion = stats.getRecordsScheduledForDeletion();
            health.recentArchivalActivity = stats.getRecentlyArchivedCount();

            return ResponseEntity.ok(health);

        } catch (Exception e) {
            LOG.error("Error during archival health check", e);
            ArchivalHealthResponse health = new ArchivalHealthResponse();
            health.status = "UNHEALTHY";
            health.errors.add("Health check failed: " + e.getMessage());
            return ResponseEntity.internalServerError().body(health);
        }
    }

    // Minimal subset of DTOs used by endpoints (kept as nested classes for brevity)
    public static class ArchivalHealthResponse {
        public String status = "HEALTHY";
        public long activeRecords;
        public long archivedRecords;
        public long scheduledForDeletion;
        public long recentArchivalActivity;
        public java.util.List<String> warnings = new java.util.ArrayList<>();
        public java.util.List<String> errors = new java.util.ArrayList<>();

        // getters/setters omitted for brevity
    }

    public static class ErrorResponse {
        public String status;
        public String message;

        public ErrorResponse() {}

        public ErrorResponse(String status, String message) {
            this.status = status;
            this.message = message;
        }

        // getters/setters omitted
    }
}
