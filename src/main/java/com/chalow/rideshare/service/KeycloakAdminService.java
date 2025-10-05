package com.chalow.rideshare.service;

public interface KeycloakAdminService {
    boolean changeUserPassword(String keycloakId, String newPassword, boolean temporary);
    boolean changeUserPasswordByEmail(String email, String newPassword, boolean temporary);
}
