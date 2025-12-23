package org.formation.projet_aida_goumble.domain.port.out;

import org.formation.projet_aida_goumble.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientPort {
    Client save(Client client);
    Optional<Client> findById(Long id);
    List<Client> findAll();
    List<Client> findByAdvisorId(Long advisorId);
    void deleteById(Long id);
    boolean existsById(Long id);
}
