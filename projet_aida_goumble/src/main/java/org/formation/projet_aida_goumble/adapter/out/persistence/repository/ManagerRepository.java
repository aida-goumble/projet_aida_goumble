package org.formation.projet_aida_goumble.adapter.out.persistence.repository;

import org.formation.projet_aida_goumble.adapter.out.persistence.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
