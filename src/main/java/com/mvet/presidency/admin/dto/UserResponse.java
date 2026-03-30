package com.mvet.presidency.admin.dto;

public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String jobTitle,
        boolean active,
        String role,
        String ministry,
        String department,
        String unit) {
}
