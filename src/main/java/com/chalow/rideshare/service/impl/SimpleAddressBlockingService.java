package com.chalow.rideshare.service.impl;

import com.chalow.rideshare.dto.BlockedAddressDto;
import com.chalow.rideshare.service.AddressBlockingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SimpleAddressBlockingService implements AddressBlockingService {
    @Override
    public Page<BlockedAddressDto> getAllBlockedAddresses(int page, int size) {
        return new PageImpl<>(Collections.emptyList());
    }

    @Override
    public BlockedAddressDto blockAddress(String address, String normalizedAddress, String reason, String blockedBy, Object blockType) {
        return new BlockedAddressDto(1L, address);
    }

    @Override
    public void unblockAddress(Long id) { /* no-op */ }
}
