package org.formation.projet_aida_goumble.adapter.out.persistence.repository;

import org.formation.projet_aida_goumble.adapter.out.persistence.entity.Advisor;
import org.formation.projet_aida_goumble.adapter.out.persistence.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
    List<Advisor> findByManagerId(Long managerId);
}
