package com.mvet.presidency.admin.repository;

import com.mvet.presidency.admin.entity.Role;
import com.mvet.presidency.admin.enums.RoleName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
