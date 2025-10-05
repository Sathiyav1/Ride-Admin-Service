package com.chalow.rideshare.service;

import com.chalow.rideshare.dto.BlockedAddressDto;
import org.springframework.data.domain.Page;

public interface AddressBlockingService {
    Page<BlockedAddressDto> getAllBlockedAddresses(int page, int size);
    BlockedAddressDto blockAddress(String address, String normalizedAddress, String reason, String blockedBy, Object blockType);
    void unblockAddress(Long id);
}
