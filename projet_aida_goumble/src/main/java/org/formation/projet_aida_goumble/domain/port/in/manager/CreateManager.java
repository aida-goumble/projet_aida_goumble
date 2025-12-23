package org.formation.projet_aida_goumble.domain.port.in.manager;

import org.formation.projet_aida_goumble.domain.model.Manager;

public interface CreateManager {
    Manager createManager(String lastName, String firstName);
}
