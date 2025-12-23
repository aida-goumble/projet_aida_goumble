package org.formation.projet_aida_goumble.adapter.out.persistence;

import org.formation.projet_aida_goumble.adapter.out.persistence.mapper.AdvisorMapper;
import org.formation.projet_aida_goumble.adapter.out.persistence.repository.AdvisorRepository;
import org.formation.projet_aida_goumble.adapter.out.persistence.repository.ManagerRepository;
import org.formation.projet_aida_goumble.domain.model.Advisor;
import org.formation.projet_aida_goumble.domain.port.out.AdvisorPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AdvisorAdapter implements AdvisorPort {
    private final AdvisorRepository advisorRepository;
    private final ManagerRepository managerRepository;
    private final AdvisorMapper mapper;

    public AdvisorAdapter(AdvisorRepository advisorRepository,
                                     ManagerRepository managerRepository,
                                     AdvisorMapper mapper) {
        this.advisorRepository = advisorRepository;
        this.managerRepository = managerRepository;
        this.mapper = mapper;
    }

    @Override
    public Advisor save(Advisor advisor) {
        org.formation.projet_aida_goumble.adapter.out.persistence.entity.Advisor entity;

        if (advisor. getId() != null) {
            entity = advisorRepository.findById(advisor. getId())
                    .orElse(mapper.toEntity(advisor));
            mapper.updateEntity(advisor, entity);
        } else {
            entity = mapper.toEntity(advisor);
        }

        if (advisor.getManagerId() != null) {
            org.formation.projet_aida_goumble.adapter.out.persistence.entity.Manager manager = managerRepository.findById(advisor.getManagerId())
                    .orElse(null);
            entity.setManager(manager);
        }

        org.formation.projet_aida_goumble.adapter.out.persistence.entity.Advisor saved = advisorRepository. save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Advisor> findById(Long id) {
        return advisorRepository.findById(id)
                .map(mapper:: toDomain);
    }

    @Override
    public List<Advisor> findAll() {
        return advisorRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Advisor> findByManagerId(Long managerId) {
        return advisorRepository.findByManagerId(managerId).stream()
                .map(mapper::toDomain)
                .collect(Collectors. toList());
    }

    @Override
    public void deleteById(Long id) {
        advisorRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return advisorRepository.existsById(id);
    }
}
