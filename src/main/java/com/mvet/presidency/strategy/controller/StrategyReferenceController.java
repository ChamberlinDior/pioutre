package com.mvet.presidency.strategy.controller;

import com.mvet.presidency.admin.dto.ReferenceResponse;
import com.mvet.presidency.common.response.ApiResponse;
import com.mvet.presidency.strategy.dto.NamedRequest;
import com.mvet.presidency.strategy.service.StrategyReferenceService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/strategy")
public class StrategyReferenceController {

    private final StrategyReferenceService service;

    public StrategyReferenceController(StrategyReferenceService service) {
        this.service = service;
    }

    @PostMapping("/pillars")
    public ApiResponse<ReferenceResponse> createPillar(@Valid @RequestBody NamedRequest request) {
        return ApiResponse.ok("Pilier créé", service.createPillar(request));
    }

    @GetMapping("/pillars")
    public ApiResponse<List<ReferenceResponse>> listPillars() {
        return ApiResponse.ok("Liste des piliers", service.listPillars());
    }

    @PostMapping("/programs")
    public ApiResponse<ReferenceResponse> createProgram(@RequestParam Long pillarId, @Valid @RequestBody NamedRequest request) {
        return ApiResponse.ok("Programme créé", service.createProgram(pillarId, request));
    }

    @GetMapping("/programs")
    public ApiResponse<List<ReferenceResponse>> listPrograms() {
        return ApiResponse.ok("Liste des programmes", service.listPrograms());
    }

    @PostMapping("/commitments")
    public ApiResponse<ReferenceResponse> createCommitment(@RequestParam Long programId, @Valid @RequestBody NamedRequest request) {
        return ApiResponse.ok("Engagement créé", service.createCommitment(programId, request));
    }

    @GetMapping("/commitments")
    public ApiResponse<List<ReferenceResponse>> listCommitments() {
        return ApiResponse.ok("Liste des engagements", service.listCommitments());
    }
}
