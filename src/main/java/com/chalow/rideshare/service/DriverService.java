package com.chalow.rideshare.service;

import com.chalow.rideshare.dto.DriverDTO;
import com.chalow.rideshare.dto.PageResponse;

public interface DriverService {
    PageResponse<DriverDTO.DriverPendingApprovalResponse> getDriversPendingApproval(int page, int size);
    DriverDTO.DriverApprovalResponse approveDriver(Long driverId, Long adminId, String notes);
    com.chalow.rideshare.entity.DocumentStorage getDriverDocumentForAdmin(Long driverId, String documentType);
    DriverDTO.DriverPendingApprovalResponse getDriverDetailsForAdmin(Long driverId);
}
