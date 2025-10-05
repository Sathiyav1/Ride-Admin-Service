package com.chalow.rideshare.service.impl;

import com.chalow.rideshare.service.DocumentVerificationManagementService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SimpleDocumentVerificationManagementService implements DocumentVerificationManagementService {
    @Override
    public DocumentVerificationResult retryDriverDocumentVerification(Long driverId, String documentType) {
        return new DocumentVerificationResult(true, "Retried", null, 1.0);
    }

    @Override
    public DocumentVerificationResult updateDriverDocumentAndRetry(Long driverId, String documentType, MultipartFile file) {
        return new DocumentVerificationResult(true, "Updated and retried", null, 1.0);
    }
}
