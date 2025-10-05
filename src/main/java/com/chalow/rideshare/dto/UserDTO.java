package com.chalow.rideshare.dto;

public class UserDTO {
    public static class AdminUserResponse {
        private Long id;
        private String email;
        private String keycloakId;

        public AdminUserResponse() {}

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getKeycloakId() { return keycloakId; }
        public void setKeycloakId(String keycloakId) { this.keycloakId = keycloakId; }
    }
}
