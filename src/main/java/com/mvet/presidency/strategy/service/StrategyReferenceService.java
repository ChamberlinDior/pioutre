package com.mvet.presidency.strategy.service;

import com.mvet.presidency.admin.dto.ReferenceResponse;
import com.mvet.presidency.admin.mapper.ReferenceMapper;
import com.mvet.presidency.common.exception.ResourceNotFoundException;
import com.mvet.presidency.strategy.dto.NamedRequest;
import com.mvet.presidency.strategy.entity.GovernmentProgram;
import com.mvet.presidency.strategy.entity.PresidentialCommitment;
import com.mvet.presidency.strategy.entity.StrategicPillar;
import com.mvet.presidency.strategy.repository.GovernmentProgramRepository;
import com.mvet.presidency.strategy.repository.PresidentialCommitmentRepository;
import com.mvet.presidency.strategy.repository.StrategicPillarRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StrategyReferenceService {

    private final StrategicPillarRepository pillarRepository;
    private final GovernmentProgramRepository programRepository;
    private final PresidentialCommitmentRepository commitmentRepository;

    public StrategyReferenceService(StrategicPillarRepository pillarRepository,
                                    GovernmentProgramRepository programRepository,
                                    PresidentialCommitmentRepository commitmentRepository) {
        this.pillarRepository = pillarRepository;
        this.programRepository = programRepository;
        this.commitmentRepository = commitmentRepository;
    }

    public ReferenceResponse createPillar(NamedRequest request) {
        StrategicPillar entity = new StrategicPillar();
        entity.setName(request.name());
        entity.setCode(request.code());
        entity.setDescription(request.description());
        return ReferenceMapper.toResponse(pillarRepository.save(entity));
    }

    public List<ReferenceResponse> listPillars() {
        return pillarRepository.findAll().stream().map(ReferenceMapper::toResponse).toList();
    }

    public ReferenceResponse createProgram(Long pillarId, NamedRequest request) {
        StrategicPillar pillar = pillarRepository.findById(pillarId)
                .orElseThrow(() -> new ResourceNotFoundException("Pilier introuvable : " + pillarId));
        GovernmentProgram entity = new GovernmentProgram();
        entity.setName(request.name());
        entity.setCode(request.code());
        entity.setDescription(request.description());
        entity.setPillar(pillar);
        return ReferenceMapper.toResponse(programRepository.save(entity));
    }

    public List<ReferenceResponse> listPrograms() {
        return programRepository.findAll().stream().map(ReferenceMapper::toResponse).toList();
    }

    public ReferenceResponse createCommitment(Long programId, NamedRequest request) {
        GovernmentProgram program = programRepository.findById(programId)
                .orElseThrow(() -> new ResourceNotFoundException("Programme introuvable : " + programId));
        PresidentialCommitment entity = new PresidentialCommitment();
        entity.setName(request.name());
        entity.setCode(request.code());
        entity.setDescription(request.description());
        entity.setProgram(program);
        return ReferenceMapper.toResponse(commitmentRepository.save(entity));
    }

    public List<ReferenceResponse> listCommitments() {
        return commitmentRepository.findAll().stream().map(ReferenceMapper::toResponse).toList();
    }
}
