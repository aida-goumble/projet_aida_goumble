package org.formation.projet_aida_goumble.repository;

import org.formation.projet_aida_goumble.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
