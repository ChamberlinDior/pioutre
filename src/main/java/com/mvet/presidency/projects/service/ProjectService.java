package com.mvet.presidency.projects.service;

import com.mvet.presidency.admin.entity.Ministry;
import com.mvet.presidency.admin.entity.User;
import com.mvet.presidency.admin.repository.MinistryRepository;
import com.mvet.presidency.admin.repository.UserRepository;
import com.mvet.presidency.common.exception.ResourceNotFoundException;
import com.mvet.presidency.projects.dto.ProjectRequest;
import com.mvet.presidency.projects.dto.ProjectResponse;
import com.mvet.presidency.projects.entity.Project;
import com.mvet.presidency.projects.mapper.ProjectMapper;
import com.mvet.presidency.projects.repository.ProjectRepository;
import com.mvet.presidency.strategy.entity.GovernmentProgram;
import com.mvet.presidency.strategy.entity.PresidentialCommitment;
import com.mvet.presidency.strategy.entity.StrategicPillar;
import com.mvet.presidency.strategy.repository.GovernmentProgramRepository;
import com.mvet.presidency.strategy.repository.PresidentialCommitmentRepository;
import com.mvet.presidency.strategy.repository.StrategicPillarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final MinistryRepository ministryRepository;
    private final StrategicPillarRepository pillarRepository;
    private final GovernmentProgramRepository programRepository;
    private final PresidentialCommitmentRepository commitmentRepository;
    private final UserRepository userRepository;

    public ProjectService(ProjectRepository projectRepository,
                          MinistryRepository ministryRepository,
                          StrategicPillarRepository pillarRepository,
                          GovernmentProgramRepository programRepository,
                          PresidentialCommitmentRepository commitmentRepository,
                          UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.ministryRepository = ministryRepository;
        this.pillarRepository = pillarRepository;
        this.programRepository = programRepository;
        this.commitmentRepository = commitmentRepository;
        this.userRepository = userRepository;
    }

    public ProjectResponse create(ProjectRequest request) {
        Project project = new Project();
        apply(project, request);
        return ProjectMapper.toResponse(projectRepository.save(project));
    }

    public List<ProjectResponse> list() {
        return projectRepository.findAll()
                .stream()
                .map(ProjectMapper::toResponse)
                .toList();
    }

    public ProjectResponse get(Long id) {
        return ProjectMapper.toResponse(findEntity(id));
    }

    public ProjectResponse update(Long id, ProjectRequest request) {
        Project project = findEntity(id);
        apply(project, request);
        return ProjectMapper.toResponse(projectRepository.save(project));
    }

    public void delete(Long id) {
        Project project = findEntity(id);
        project.setDeleted(true);
        projectRepository.save(project);
    }

    public Project findEntity(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projet introuvable : " + id));
    }

    private void apply(Project project, ProjectRequest request) {
        Ministry ministry = ministryRepository.findById(request.ministryId())
                .orElseThrow(() -> new ResourceNotFoundException("Ministère introuvable : " + request.ministryId()));

        project.setProjectCode(request.projectCode());
        project.setTitle(request.title());
        project.setDescription(request.description());
        project.setStatus(request.status());
        project.setPriority(request.priority());
        project.setApprovedBudget(request.approvedBudget());
        project.setPlannedStartDate(request.plannedStartDate());
        project.setPlannedEndDate(request.plannedEndDate());
        project.setGeographicZone(request.geographicZone());
        project.setMinistry(ministry);

        if (request.pillarId() != null) {
            StrategicPillar pillar = pillarRepository.findById(request.pillarId())
                    .orElseThrow(() -> new ResourceNotFoundException("Pilier introuvable : " + request.pillarId()));
            project.setPillar(pillar);
        }

        if (request.programId() != null) {
            GovernmentProgram program = programRepository.findById(request.programId())
                    .orElseThrow(() -> new ResourceNotFoundException("Programme introuvable : " + request.programId()));
            project.setProgram(program);
        }

        if (request.commitmentId() != null) {
            PresidentialCommitment commitment = commitmentRepository.findById(request.commitmentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Engagement introuvable : " + request.commitmentId()));
            project.setCommitment(commitment);
        }

        if (request.ownerId() != null) {
            User owner = userRepository.findById(request.ownerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Responsable introuvable : " + request.ownerId()));
            project.setOwner(owner);
        }
    }
}