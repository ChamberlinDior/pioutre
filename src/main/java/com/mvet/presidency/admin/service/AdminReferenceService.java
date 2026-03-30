package com.mvet.presidency.admin.service;

import com.mvet.presidency.admin.dto.ReferenceResponse;
import com.mvet.presidency.admin.entity.Department;
import com.mvet.presidency.admin.entity.Institution;
import com.mvet.presidency.admin.entity.Ministry;
import com.mvet.presidency.admin.entity.Unit;
import com.mvet.presidency.admin.mapper.ReferenceMapper;
import com.mvet.presidency.admin.repository.DepartmentRepository;
import com.mvet.presidency.admin.repository.InstitutionRepository;
import com.mvet.presidency.admin.repository.MinistryRepository;
import com.mvet.presidency.admin.repository.UnitRepository;
import com.mvet.presidency.common.exception.ResourceNotFoundException;
import com.mvet.presidency.strategy.dto.NamedRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminReferenceService {

    private final InstitutionRepository institutionRepository;
    private final MinistryRepository ministryRepository;
    private final DepartmentRepository departmentRepository;
    private final UnitRepository unitRepository;

    public AdminReferenceService(InstitutionRepository institutionRepository,
                                 MinistryRepository ministryRepository,
                                 DepartmentRepository departmentRepository,
                                 UnitRepository unitRepository) {
        this.institutionRepository = institutionRepository;
        this.ministryRepository = ministryRepository;
        this.departmentRepository = departmentRepository;
        this.unitRepository = unitRepository;
    }

    public ReferenceResponse createInstitution(NamedRequest request) {
        Institution entity = new Institution();
        entity.setName(request.name());
        entity.setCode(request.code());
        entity.setDescription(request.description());
        return ReferenceMapper.toResponse(institutionRepository.save(entity));
    }

    public List<ReferenceResponse> listInstitutions() {
        return institutionRepository.findAll()
                .stream()
                .map(ReferenceMapper::toResponse)
                .toList();
    }

    public ReferenceResponse createMinistry(Long institutionId, NamedRequest request) {
        Institution institution = institutionRepository.findById(institutionId)
                .orElseThrow(() -> new ResourceNotFoundException("Institution introuvable : " + institutionId));

        Ministry entity = new Ministry();
        entity.setName(request.name());
        entity.setCode(request.code());
        entity.setDescription(request.description());
        entity.setInstitution(institution);

        return ReferenceMapper.toResponse(ministryRepository.save(entity));
    }

    public List<ReferenceResponse> listMinistries() {
        return ministryRepository.findAll()
                .stream()
                .map(ReferenceMapper::toResponse)
                .toList();
    }

    public ReferenceResponse createDepartment(Long ministryId, NamedRequest request) {
        Ministry ministry = ministryRepository.findById(ministryId)
                .orElseThrow(() -> new ResourceNotFoundException("Ministère introuvable : " + ministryId));

        Department entity = new Department();
        entity.setName(request.name());
        entity.setCode(request.code());
        entity.setDescription(request.description());
        entity.setMinistry(ministry);

        return ReferenceMapper.toResponse(departmentRepository.save(entity));
    }

    public List<ReferenceResponse> listDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(ReferenceMapper::toResponse)
                .toList();
    }

    public ReferenceResponse createUnit(Long departmentId, NamedRequest request) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Département introuvable : " + departmentId));

        Unit entity = new Unit();
        entity.setName(request.name());
        entity.setCode(request.code());
        entity.setDescription(request.description());
        entity.setDepartment(department);

        return ReferenceMapper.toResponse(unitRepository.save(entity));
    }

    public List<ReferenceResponse> listUnits() {
        return unitRepository.findAll()
                .stream()
                .map(ReferenceMapper::toResponse)
                .toList();
    }
}