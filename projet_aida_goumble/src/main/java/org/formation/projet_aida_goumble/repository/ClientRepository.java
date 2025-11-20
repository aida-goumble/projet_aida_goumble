package org.formation.projet_aida_goumble.repository;

import org.formation.projet_aida_goumble.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
