package org.formation.projet_aida_goumble.domain.port.in.advisor;

import org.formation.projet_aida_goumble.domain.model.Advisor;

public interface AssignAdvisor {
    Advisor assignAdvisorToManager(Long advisorId, Long managerId);

}
