package org.formation.projet_aida_goumble.domain.port.out;

import org.formation.projet_aida_goumble.domain.model.Advisor;

import java.util.List;
import java.util.Optional;

public interface AdvisorPort {
    Advisor save(Advisor advisor);
    Optional<Advisor> findById(Long id);
    List<Advisor> findAll();
    List<Advisor> findByManagerId(Long managerId);
    void deleteById(Long id);
    boolean existsById(Long id);
}
