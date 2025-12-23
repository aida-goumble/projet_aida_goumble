package org.formation.projet_aida_goumble.domain.port.in.advisor;

import org.formation.projet_aida_goumble.domain.model.Advisor;

import java.util.List;

public interface GetAdvisor {
    Advisor getAdvisorById(Long id);
    List<Advisor> getAllAdvisors();
    List<Advisor> getAdvisorsByManagerId(Long managerId);
}
