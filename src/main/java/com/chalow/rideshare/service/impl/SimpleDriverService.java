package com.chalow.rideshare.service.impl;

import com.chalow.rideshare.dto.DriverDTO;
import com.chalow.rideshare.dto.PageResponse;
import com.chalow.rideshare.entity.DocumentStorage;
import com.chalow.rideshare.service.DriverService;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SimpleDriverService implements DriverService {
    @Override
    public PageResponse<DriverDTO.DriverPendingApprovalResponse> getDriversPendingApproval(int page, int size) {
        return new PageResponse<>(Collections.emptyList(), new PageImpl<>(Collections.emptyList()));
    }

    @Override
    public DriverDTO.DriverApprovalResponse approveDriver(Long driverId, Long adminId, String notes) {
        return new DriverDTO.DriverApprovalResponse("SUCCESS", "Approved", driverId, java.time.LocalDateTime.now());
    }

    @Override
    public DocumentStorage getDriverDocumentForAdmin(Long driverId, String documentType) {
        return new DocumentStorage();
    }

    @Override
    public DriverDTO.DriverPendingApprovalResponse getDriverDetailsForAdmin(Long driverId) {
        return new DriverDTO.DriverPendingApprovalResponse();
    }
}
