package org.formation.projet_aida_goumble.domain.port.in.manager;

import org.formation.projet_aida_goumble.domain.model.Manager;

import java.util.List;

public interface GetManager {
    Manager getManagerById(Long id);
    List<Manager> getAllManagers();
}
