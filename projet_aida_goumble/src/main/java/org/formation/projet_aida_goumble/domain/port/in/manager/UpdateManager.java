package org.formation.projet_aida_goumble.domain.port.in.manager;

import org.formation.projet_aida_goumble.domain.model.Manager;

public interface UpdateManager {
    Manager updateManager(Long id, String lastName, String firstName);

}
