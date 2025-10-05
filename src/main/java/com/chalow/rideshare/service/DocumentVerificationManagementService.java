package com.chalow.rideshare.service;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentVerificationManagementService {
    record DocumentVerificationResult(boolean success, String message, Object details, double score) {}

    DocumentVerificationResult retryDriverDocumentVerification(Long driverId, String documentType);
    DocumentVerificationResult updateDriverDocumentAndRetry(Long driverId, String documentType, MultipartFile file);
}
