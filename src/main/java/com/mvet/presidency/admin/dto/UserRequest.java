package com.mvet.presidency.admin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @Email @NotBlank String email,
        @NotBlank String password,
        String phone,
        String jobTitle,
        @NotNull Long roleId,
        Long ministryId,
        Long departmentId,
        Long unitId,
        Boolean active) {
}
