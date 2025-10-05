package com.chalow.rideshare.entity;

public class DocumentStorage {
    private byte[] content;
    private String contentType;
    private String originalFileName;

    public byte[] getContent() { return content; }
    public String getContentType() { return contentType; }
    public String getOriginalFileName() { return originalFileName; }
}
