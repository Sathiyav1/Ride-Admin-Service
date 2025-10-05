package com.chalow.rideshare.service.impl;

import com.chalow.rideshare.dto.UserDTO;
import com.chalow.rideshare.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SimpleUserService implements UserService {
    @Override
    public boolean isNotAdmin(Authentication authentication) { return false; }

    @Override
    public List<UserDTO.AdminUserResponse> getNonAdminUsers(int page, int size) { return Collections.emptyList(); }

    @Override
    public boolean deleteUser(Long userId) { return true; }
}
