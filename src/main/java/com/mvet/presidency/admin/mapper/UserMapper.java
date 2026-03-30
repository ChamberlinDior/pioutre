package com.mvet.presidency.admin.mapper;

import com.mvet.presidency.admin.dto.UserResponse;
import com.mvet.presidency.admin.entity.User;

public final class UserMapper {

    private UserMapper() {
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                user.getJobTitle(),
                user.isActive(),
                user.getRole() != null ? user.getRole().getName().name() : null,
                user.getMinistry() != null ? user.getMinistry().getName() : null,
                user.getDepartment() != null ? user.getDepartment().getName() : null,
                user.getUnit() != null ? user.getUnit().getName() : null
        );
    }
}
