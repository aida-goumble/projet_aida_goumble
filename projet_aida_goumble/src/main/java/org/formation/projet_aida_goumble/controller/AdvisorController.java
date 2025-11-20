package org.formation.projet_aida_goumble.controller;

import org.formation.projet_aida_goumble.entity.Advisor;
import org.formation.projet_aida_goumble.entity.Client;
import org.formation.projet_aida_goumble.service.AdvisorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AdvisorController {
    private final AdvisorService advisorService;
    public AdvisorController(AdvisorService advisorService) {
        this.advisorService = advisorService;
    }


    @GetMapping("/advisor")
    public List<Advisor> getClients() {
        return advisorService.getAdvisors();
    }

    @PostMapping("/advisor")
    public Advisor createClient(@RequestBody Advisor advisor) {
        return advisorService.saveAdvisor(advisor);
    }

    @GetMapping("/advisor/{id}")
    public ResponseEntity<Advisor> getAdvisorById(@PathVariable Long id) {
        return advisorService.getAdvisorsById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/advisor")
    public Advisor deleteAdvisor(@RequestBody Advisor advisor) {
        return advisorService.deleteAdvisor(advisor);
    }
}
