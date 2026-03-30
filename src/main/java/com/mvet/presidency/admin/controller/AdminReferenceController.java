package com.mvet.presidency.admin.controller;

import com.mvet.presidency.admin.dto.ReferenceResponse;
import com.mvet.presidency.admin.service.AdminReferenceService;
import com.mvet.presidency.common.response.ApiResponse;
import com.mvet.presidency.strategy.dto.NamedRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/reference")
public class AdminReferenceController {

    private final AdminReferenceService service;

    public AdminReferenceController(AdminReferenceService service) {
        this.service = service;
    }

    @PostMapping("/institutions")
    public ApiResponse<ReferenceResponse> createInstitution(@Valid @RequestBody NamedRequest request) {
        return ApiResponse.ok("Institution créée", service.createInstitution(request));
    }

    @GetMapping("/institutions")
    public ApiResponse<List<ReferenceResponse>> listInstitutions() {
        return ApiResponse.ok("Liste des institutions", service.listInstitutions());
    }

    @PostMapping("/ministries")
    public ApiResponse<ReferenceResponse> createMinistry(
            @RequestParam Long institutionId,
            @Valid @RequestBody NamedRequest request
    ) {
        return ApiResponse.ok("Ministère créé", service.createMinistry(institutionId, request));
    }

    @GetMapping("/ministries")
    public ApiResponse<List<ReferenceResponse>> listMinistries() {
        return ApiResponse.ok("Liste des ministères", service.listMinistries());
    }

    @PostMapping("/departments")
    public ApiResponse<ReferenceResponse> createDepartment(
            @RequestParam Long ministryId,
            @Valid @RequestBody NamedRequest request
    ) {
        return ApiResponse.ok("Département créé", service.createDepartment(ministryId, request));
    }

    @GetMapping("/departments")
    public ApiResponse<List<ReferenceResponse>> listDepartments() {
        return ApiResponse.ok("Liste des départements", service.listDepartments());
    }

    @PostMapping("/units")
    public ApiResponse<ReferenceResponse> createUnit(
            @RequestParam Long departmentId,
            @Valid @RequestBody NamedRequest request
    ) {
        return ApiResponse.ok("Unité créée", service.createUnit(departmentId, request));
    }

    @GetMapping("/units")
    public ApiResponse<List<ReferenceResponse>> listUnits() {
        return ApiResponse.ok("Liste des unités", service.listUnits());
    }
}