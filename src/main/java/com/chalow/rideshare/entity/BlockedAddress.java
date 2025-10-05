package com.chalow.rideshare.entity;

public class BlockedAddress {
    public enum BlockType { SOFT, HARD }
    private Long id;
    private String address;

    public Long getId() { return id; }
    public String getAddress() { return address; }
}
