package com.mvet.presidency.admin.service;

import com.mvet.presidency.admin.dto.UserRequest;
import com.mvet.presidency.admin.dto.UserResponse;
import com.mvet.presidency.admin.entity.Department;
import com.mvet.presidency.admin.entity.Ministry;
import com.mvet.presidency.admin.entity.Role;
import com.mvet.presidency.admin.entity.Unit;
import com.mvet.presidency.admin.entity.User;
import com.mvet.presidency.admin.mapper.UserMapper;
import com.mvet.presidency.admin.repository.DepartmentRepository;
import com.mvet.presidency.admin.repository.MinistryRepository;
import com.mvet.presidency.admin.repository.RoleRepository;
import com.mvet.presidency.admin.repository.UnitRepository;
import com.mvet.presidency.admin.repository.UserRepository;
import com.mvet.presidency.common.exception.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final MinistryRepository ministryRepository;
    private final DepartmentRepository departmentRepository;
    private final UnitRepository unitRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       MinistryRepository ministryRepository,
                       DepartmentRepository departmentRepository,
                       UnitRepository unitRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.ministryRepository = ministryRepository;
        this.departmentRepository = departmentRepository;
        this.unitRepository = unitRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse create(UserRequest request) {
        User user = new User();
        apply(user, request, true);
        return UserMapper.toResponse(userRepository.save(user));
    }

    public List<UserResponse> list() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }

    public UserResponse get(Long id) {
        return UserMapper.toResponse(findEntity(id));
    }

    public UserResponse update(Long id, UserRequest request) {
        User user = findEntity(id);
        apply(user, request, false);
        return UserMapper.toResponse(userRepository.save(user));
    }

    public void delete(Long id) {
        User user = findEntity(id);
        user.setDeleted(true);
        userRepository.save(user);
    }

    public User findEntity(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur introuvable : " + id));
    }

    private void apply(User user, UserRequest request, boolean create) {
        Role role = roleRepository.findById(request.roleId())
                .orElseThrow(() -> new ResourceNotFoundException("Rôle introuvable : " + request.roleId()));

        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setEmail(request.email());
        user.setPhone(request.phone());
        user.setJobTitle(request.jobTitle());
        user.setRole(role);
        user.setActive(request.active() == null || request.active());

        if (create || (request.password() != null && !request.password().isBlank())) {
            user.setPassword(passwordEncoder.encode(request.password()));
        }

        if (request.ministryId() != null) {
            Ministry ministry = ministryRepository.findById(request.ministryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Ministère introuvable : " + request.ministryId()));
            user.setMinistry(ministry);
        } else {
            user.setMinistry(null);
        }

        if (request.departmentId() != null) {
            Department department = departmentRepository.findById(request.departmentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Département introuvable : " + request.departmentId()));
            user.setDepartment(department);
        } else {
            user.setDepartment(null);
        }

        if (request.unitId() != null) {
            Unit unit = unitRepository.findById(request.unitId())
                    .orElseThrow(() -> new ResourceNotFoundException("Unité introuvable : " + request.unitId()));
            user.setUnit(unit);
        } else {
            user.setUnit(null);
        }
    }
}