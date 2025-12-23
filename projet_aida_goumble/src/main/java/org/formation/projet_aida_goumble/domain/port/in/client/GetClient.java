package org.formation.projet_aida_goumble.domain.port.in.client;

import org.formation.projet_aida_goumble.domain.model.Client;

import java.util.List;

public interface GetClient {
    Client getClientById(Long id);
    List<Client> getAllClients();
    List<Client> getClientsByAdvisorId(Long advisorId);
}
