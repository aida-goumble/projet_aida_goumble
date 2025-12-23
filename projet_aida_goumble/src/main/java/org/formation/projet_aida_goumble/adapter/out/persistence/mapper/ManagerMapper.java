package org.formation.projet_aida_goumble.adapter.out.persistence.mapper;

import org.formation.projet_aida_goumble.domain.model.Manager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ManagerMapper {
    public Manager toDomain(org.formation.projet_aida_goumble.adapter.out.persistence.entity.Manager entity) {
        if (entity == null) {
            return null;
        }

        List<Long> advisorIds = entity.getAdvisors() != null
                ? entity.getAdvisors().stream()
                .map(advisor -> advisor.getId())
                .collect(Collectors. toList())
                : List. of();

        return new Manager(
                entity.getId(),
                entity.getLastName(),
                entity.getFirstName(),
                advisorIds
        );
    }

    public org.formation.projet_aida_goumble.adapter.out.persistence.entity.Manager toEntity(Manager domain) {
        if (domain == null) {
            return null;
        }

        org.formation.projet_aida_goumble.adapter.out.persistence.entity.Manager entity = new org.formation.projet_aida_goumble.adapter.out.persistence.entity.Manager();
        entity.setId(domain. getId());
        entity.setLastName(domain.getLastName());
        entity.setFirstName(domain.getFirstName());

        return entity;
    }

    public void updateEntity(Manager domain, org.formation.projet_aida_goumble.adapter.out.persistence.entity.Manager entity) {
        if (domain == null || entity == null) {
            return;
        }

        entity.setLastName(domain.getLastName());
        entity.setFirstName(domain.getFirstName());
    }
}
