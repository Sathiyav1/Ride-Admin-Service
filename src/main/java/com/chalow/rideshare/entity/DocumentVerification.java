package com.chalow.rideshare.entity;

public class DocumentVerification {
    public enum DocumentType { LICENSE, INSURANCE, REGISTRATION }
    private DocumentType documentType;
    private boolean verified;
    private boolean faceVerified;

    public DocumentType getDocumentType() { return documentType; }
    public boolean isVerified() { return verified; }
    public Boolean getFaceVerified() { return faceVerified; }
}
