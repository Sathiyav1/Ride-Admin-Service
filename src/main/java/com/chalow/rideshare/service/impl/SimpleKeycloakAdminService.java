package com.chalow.rideshare.service.impl;

import com.chalow.rideshare.service.KeycloakAdminService;
import org.springframework.stereotype.Service;

@Service
public class SimpleKeycloakAdminService implements KeycloakAdminService {
    @Override
    public boolean changeUserPassword(String keycloakId, String newPassword, boolean temporary) { return true; }

    @Override
    public boolean changeUserPasswordByEmail(String email, String newPassword, boolean temporary) { return true; }
}
