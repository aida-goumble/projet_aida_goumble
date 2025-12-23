package org.formation.projet_aida_goumble.application.service;

import jakarta.transaction.Transactional;
import org.formation.projet_aida_goumble.adapter.out.persistence.repository.ManagerRepository;
import org.formation.projet_aida_goumble.domain.model.Manager;
import org.formation.projet_aida_goumble.domain.port.in.manager.CreateManager;
import org.formation.projet_aida_goumble.domain.port.in.manager.DeleteManager;
import org.formation.projet_aida_goumble.domain.port.in.manager.GetManager;
import org.formation.projet_aida_goumble.domain.port.in.manager.UpdateManager;
import org.formation.projet_aida_goumble.domain.port.out.ManagerPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ManagerService implements CreateManager, UpdateManager, DeleteManager, GetManager {
    private final ManagerPort managerPort;

    public ManagerService(ManagerPort managerPort) {
        this.managerPort = managerPort;
    }

    @Override
    public Manager createManager(String lastName, String firstName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }

        Manager manager = new Manager(lastName, firstName);
        return managerPort.save(manager);
    }

    @Override
    public Manager updateManager(Long id, String lastName, String firstName) {
        Manager manager = managerPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Manager not found"));

        manager.updatePersonalInfo(lastName, firstName);

        return managerPort.save(manager);
    }

    @Override
    public void deleteManager(Long id) {
        if (!managerPort.existsById(id)) {
            throw new IllegalArgumentException("Manager not found");
        }
        managerPort.deleteById(id);
    }

    @Override
    public Manager getManagerById(Long id) {
        return managerPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Manager not found"));
    }

    @Override
    public List<Manager> getAllManagers() {
        return managerPort.findAll();
    }
}
