package org.formation.projet_aida_goumble.adapter.out.persistence;

import org.formation.projet_aida_goumble.adapter.out.persistence.mapper.ManagerMapper;
import org.formation.projet_aida_goumble.adapter.out.persistence.repository.ManagerRepository;
import org.formation.projet_aida_goumble.domain.model.Manager;
import org.formation.projet_aida_goumble.domain.port.out.ManagerPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ManagerAdapter implements ManagerPort {
    private final ManagerRepository managerRepository;
    private final ManagerMapper mapper;

    public ManagerAdapter(ManagerRepository managerRepository,
                                     ManagerMapper mapper) {
        this.managerRepository = managerRepository;
        this.mapper = mapper;
    }

    @Override
    public Manager save(Manager manager) {
        org.formation.projet_aida_goumble.adapter.out.persistence.entity.Manager entity;

        if (manager. getId() != null) {
            entity = managerRepository.findById(manager. getId())
                    .orElse(mapper.toEntity(manager));
            mapper.updateEntity(manager, entity);
        } else {
            entity = mapper.toEntity(manager);
        }

        org.formation.projet_aida_goumble.adapter.out.persistence.entity.Manager saved = managerRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Manager> findById(Long id) {
        return managerRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Manager> findAll() {
        return managerRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        managerRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return managerRepository.existsById(id);
    }
}
