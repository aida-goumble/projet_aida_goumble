package org.formation.projet_aida_goumble.domain.port.in.advisor;

import org.formation.projet_aida_goumble.domain.model.Advisor;

public interface UpdateAdvisor {
    Advisor updateAdvisor(Long id, String lastName, String firstName);

}
