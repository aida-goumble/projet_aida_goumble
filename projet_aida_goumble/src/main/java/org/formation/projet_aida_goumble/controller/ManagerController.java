package org.formation.projet_aida_goumble.controller;

import org.formation.projet_aida_goumble.entity.Client;
import org.formation.projet_aida_goumble.entity.Manager;
import org.formation.projet_aida_goumble.service.ManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ManagerController {
    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }


    @GetMapping("/manager")
    public List<Manager> getManagers() {
        return managerService.getManagers();
    }

    @PostMapping("/manager")
    public Manager createManager(@RequestBody Manager manager) {
        return managerService.saveManager(manager);
    }

    @GetMapping("/manager/{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable Long id) {
        return managerService.getManagerById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/manager")
    public Manager deleteManager(@RequestBody Manager manager) {
        return managerService.deleteManager(manager);
    }
}
