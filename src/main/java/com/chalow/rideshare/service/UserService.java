package com.chalow.rideshare.service;

import com.chalow.rideshare.dto.UserDTO;
import org.springframework.security.core.Authentication;
import java.util.List;

public interface UserService {
    boolean isNotAdmin(Authentication authentication);
    List<UserDTO.AdminUserResponse> getNonAdminUsers(int page, int size);
    boolean deleteUser(Long userId);
}
