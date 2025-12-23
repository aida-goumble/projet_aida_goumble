package org.formation.projet_aida_goumble.adapter.in.web.controller;

import org.formation.projet_aida_goumble.adapter.in.web.dto.AdvisorDto;
import org.formation.projet_aida_goumble.adapter.in.web.dto.AssignAdvisorToManagerRequest;
import org.formation.projet_aida_goumble.adapter.in.web.dto.CreateAdvisorRequest;
import org.formation.projet_aida_goumble.adapter.in.web.dto.UpdateAdvisorRequest;
import org.formation.projet_aida_goumble.adapter.in.web.mapper.AdvisorDtoMapper;
import org.formation.projet_aida_goumble.application.service.AdvisorService;
import org.formation.projet_aida_goumble.domain.model.Advisor;
import org.formation.projet_aida_goumble.domain.port.in.advisor.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/advisors")

public class AdvisorController {
    private final CreateAdvisor createAdvisor;
    private final UpdateAdvisor updateAdvisor;
    private final DeleteAdvisor deleteAdvisor;
    private final GetAdvisor getAdvisor;
    private final AssignAdvisor assignAdvisor;
    private final AdvisorDtoMapper mapper;


    public AdvisorController(CreateAdvisor createAdvisor, UpdateAdvisor updateAdvisor, DeleteAdvisor deleteAdvisor, GetAdvisor getAdvisor, AssignAdvisor assignAdvisor, AdvisorDtoMapper mapper) {
        this.createAdvisor = createAdvisor;
        this.updateAdvisor = updateAdvisor;
        this.deleteAdvisor = deleteAdvisor;
        this.getAdvisor = getAdvisor;
        this.assignAdvisor = assignAdvisor;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<AdvisorDto> createAdvisor(@RequestBody CreateAdvisorRequest request) {
        Advisor advisor = createAdvisor.createAdvisor(
                request.getLastName(),
                request.getFirstName()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(advisor));
    }

    @GetMapping
    public ResponseEntity<List<AdvisorDto>> getAllAdvisors() {
        List<AdvisorDto> advisors = getAdvisor.getAllAdvisors().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(advisors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvisorDto> getAdvisorById(@PathVariable Long id) {
        Advisor advisor = getAdvisor.getAdvisorById(id);
        return ResponseEntity.ok(mapper.toDto(advisor));
    }

    @GetMapping("/by-manager/{managerId}")
    public ResponseEntity<List<AdvisorDto>> getAdvisorsByManager(@PathVariable Long managerId) {
        List<AdvisorDto> advisors = getAdvisor.getAdvisorsByManagerId(managerId).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(advisors);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdvisorDto> updateAdvisor(@PathVariable Long id,
                                                    @RequestBody UpdateAdvisorRequest request) {
        Advisor advisor = updateAdvisor.updateAdvisor(
                id,
                request.getLastName(),
                request.getFirstName()
        );
        return ResponseEntity.ok(mapper.toDto(advisor));
    }

    @PutMapping("/{id}/assign-manager")
    public ResponseEntity<AdvisorDto> assignAdvisorToManager(@PathVariable Long id,
                                                             @RequestBody AssignAdvisorToManagerRequest request) {
        Advisor advisor = assignAdvisor.assignAdvisorToManager(id, request. getManagerId());
        return ResponseEntity.ok(mapper.toDto(advisor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvisor(@PathVariable Long id) {
        deleteAdvisor.deleteAdvisor(id);
        return ResponseEntity.noContent().build();
    }
}
