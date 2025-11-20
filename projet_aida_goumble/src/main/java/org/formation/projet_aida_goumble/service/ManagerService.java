package org.formation.projet_aida_goumble.service;

import jakarta.transaction.Transactional;
import org.formation.projet_aida_goumble.entity.Manager;
import org.formation.projet_aida_goumble.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> getManagers(){
        return managerRepository.findAll();
    }

    public Optional<Manager> getManagerById(Long id){
        return managerRepository.findById(id);
    }
    @Transactional
    public Manager saveManager(Manager manager){
        managerRepository.save(manager);
        return manager;
    }
    @Transactional
    public Manager deleteManager(Manager manager){
        managerRepository.delete(manager);
        return manager;
    }
}
