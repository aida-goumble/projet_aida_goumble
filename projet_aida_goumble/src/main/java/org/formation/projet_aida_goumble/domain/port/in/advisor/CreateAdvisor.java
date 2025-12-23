package org.formation.projet_aida_goumble.domain.port.in.advisor;

import org.formation.projet_aida_goumble.domain.model.Advisor;

public interface CreateAdvisor {
    Advisor createAdvisor(String lastName, String firstName);

}
