package org.formation.projet_aida_goumble.application.service;

import jakarta.transaction.Transactional;
import org.formation.projet_aida_goumble.adapter.out.persistence.repository.AdvisorRepository;
import org.formation.projet_aida_goumble.domain.model.Advisor;
import org.formation.projet_aida_goumble.domain.model.Client;
import org.formation.projet_aida_goumble.domain.model.Manager;
import org.formation.projet_aida_goumble.domain.port.in.advisor.*;
import org.formation.projet_aida_goumble.domain.port.out.AdvisorPort;
import org.formation.projet_aida_goumble.domain.port.out.ClientPort;
import org.formation.projet_aida_goumble.domain.port.out.ManagerPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdvisorService implements CreateAdvisor, UpdateAdvisor, DeleteAdvisor, GetAdvisor, AssignAdvisor {
    private final ManagerPort managerPort;
    private final AdvisorPort advisorPort;

    public AdvisorService(ManagerPort managerPort, AdvisorPort advisorPort) {
        this.managerPort = managerPort;
        this.advisorPort = advisorPort;
    }

    @Override
    public Advisor createAdvisor(String lastName, String firstName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }

        Advisor advisor = new Advisor(lastName, firstName);
        return advisorPort.save(advisor);
    }

    @Override
    public Advisor updateAdvisor(Long id, String lastName, String firstName) {
        Advisor advisor = advisorPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Advisor not found"));

        advisor.updatePersonalInfo(lastName, firstName);

        return advisorPort. save(advisor);
    }

    @Override
    public void deleteAdvisor(Long id) {
        if (!advisorPort.existsById(id)) {
            throw new IllegalArgumentException("Advisor not found");
        }
        advisorPort.deleteById(id);
    }

    @Override
    public Advisor getAdvisorById(Long id) {
        return advisorPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Advisor not found"));
    }

    @Override
    public List<Advisor> getAllAdvisors() {
        return advisorPort.findAll();
    }

    @Override
    public List<Advisor> getAdvisorsByManagerId(Long managerId) {
        return advisorPort.findByManagerId(managerId);
    }

    @Override
    public Advisor assignAdvisorToManager(Long advisorId, Long managerId) {
        Advisor advisor = advisorPort.findById(advisorId)
                .orElseThrow(() -> new IllegalArgumentException("Advisor not found"));

        Manager manager = managerPort. findById(managerId)
                .orElseThrow(() -> new IllegalArgumentException("Manager not found"));

        advisor.assignToManager(managerId);
        manager.addAdvisor(advisorId);

        managerPort.save(manager);
        return advisorPort.save(advisor);
    }

}
