package com.mvet.presidency.config;

import com.mvet.presidency.admin.entity.Role;
import com.mvet.presidency.admin.entity.User;
import com.mvet.presidency.admin.enums.RoleName;
import com.mvet.presidency.admin.repository.RoleRepository;
import com.mvet.presidency.admin.repository.UserRepository;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initRoles(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Arrays.stream(RoleName.values()).forEach(roleName -> {
                roleRepository.findByName(roleName).orElseGet(() -> {
                    Role role = new Role();
                    role.setName(roleName);
                    role.setDescription("Rôle système " + roleName.name());
                    return roleRepository.save(role);
                });
            });

            if (userRepository.findByEmailIgnoreCase("admin@mvet.gouv.ga").isEmpty()) {
                Role adminRole = roleRepository.findByName(RoleName.ADMIN_SYSTEME).orElseThrow();
                User user = new User();
                user.setFirstName("Super");
                user.setLastName("Admin");
                user.setEmail("admin@mvet.gouv.ga");
                user.setPassword(passwordEncoder.encode("Admin@2026"));
                user.setRole(adminRole);
                user.setJobTitle("Administrateur système");
                userRepository.save(user);
            }
        };
    }
}
