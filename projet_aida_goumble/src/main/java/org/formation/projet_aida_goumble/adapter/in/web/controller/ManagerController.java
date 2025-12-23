package org.formation.projet_aida_goumble.adapter.in.web.controller;

import org.formation.projet_aida_goumble.adapter.in.web.dto.CreateManagerRequest;
import org.formation.projet_aida_goumble.adapter.in.web.dto.ManagerDto;
import org.formation.projet_aida_goumble.adapter.in.web.dto.UpdateManagerRequest;
import org.formation.projet_aida_goumble.adapter.in.web.mapper.ManagerDtoMapper;
import org.formation.projet_aida_goumble.application.service.ManagerService;
import org.formation.projet_aida_goumble.domain.model.Manager;
import org.formation.projet_aida_goumble.domain.port.in.manager.CreateManager;
import org.formation.projet_aida_goumble.domain.port.in.manager.DeleteManager;
import org.formation.projet_aida_goumble.domain.port.in.manager.GetManager;
import org.formation.projet_aida_goumble.domain.port.in.manager.UpdateManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {
    private final CreateManager createManager;
    private final UpdateManager updateManager;
    private final DeleteManager deleteManager;
    private final GetManager getManager;
    private final ManagerDtoMapper mapper;

    public ManagerController(CreateManager createManager, UpdateManager updateManager, DeleteManager deleteManager, GetManager getManager, ManagerDtoMapper mapper) {
        this.createManager = createManager;
        this.updateManager = updateManager;
        this.deleteManager = deleteManager;
        this.getManager = getManager;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ManagerDto> createManager(@RequestBody CreateManagerRequest request) {
        Manager manager = createManager.createManager(
                request.getLastName(),
                request.getFirstName()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(manager));
    }

    @GetMapping
    public ResponseEntity<List<ManagerDto>> getAllManagers() {
        List<ManagerDto> managers = getManager.getAllManagers().stream()
                .map(mapper:: toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(managers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManagerDto> getManagerById(@PathVariable Long id) {
        Manager manager = getManager.getManagerById(id);
        return ResponseEntity.ok(mapper.toDto(manager));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManagerDto> updateManager(@PathVariable Long id,
                                                    @RequestBody UpdateManagerRequest request) {
        Manager manager = updateManager.updateManager(
                id,
                request.getLastName(),
                request.getFirstName()
        );
        return ResponseEntity.ok(mapper.toDto(manager));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManager(@PathVariable Long id) {
        deleteManager.deleteManager(id);
        return ResponseEntity.noContent().build();
    }
}
