package org.formation.projet_aida_goumble.domain.port.in.client;

import org.formation.projet_aida_goumble.domain.model.Client;

public interface AssignClient {
    Client assignClientToAdvisor(Long clientId, Long advisorId);

}
