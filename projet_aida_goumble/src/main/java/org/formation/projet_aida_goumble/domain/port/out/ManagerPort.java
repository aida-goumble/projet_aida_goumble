package org.formation.projet_aida_goumble.domain.port.out;

import org.formation.projet_aida_goumble.domain.model.Manager;

import java.util.List;
import java.util.Optional;

public interface ManagerPort {
    Manager save(Manager manager);
    Optional<Manager> findById(Long id);
    List<Manager> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
}
