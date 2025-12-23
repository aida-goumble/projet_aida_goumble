package org.formation.projet_aida_goumble.adapter.out.persistence.mapper;

import org.formation.projet_aida_goumble.domain.model.Advisor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdvisorMapper {
    public Advisor toDomain(org.formation.projet_aida_goumble.adapter.out.persistence.entity.Advisor entity) {
        if (entity == null) {
            return null;
        }

        Long managerId = entity.getManager() != null ? entity.getManager().getId() : null;

        List<Long> clientIds = entity.getClients() != null
                ? entity.getClients().stream()
                .map(client -> client.getId())
                .collect(Collectors.toList())
                : List.of();

        return new Advisor(
                entity. getId(),
                entity.getLastName(),
                entity.getFirstName(),
                managerId,
                clientIds
        );
    }

    public org.formation.projet_aida_goumble.adapter.out.persistence.entity.Advisor toEntity(Advisor domain) {
        if (domain == null) {
            return null;
        }

        org.formation.projet_aida_goumble.adapter.out.persistence.entity.Advisor entity = new org.formation.projet_aida_goumble.adapter.out.persistence.entity.Advisor();
        entity.setId(domain.getId());
        entity.setLastName(domain.getLastName());
        entity.setFirstName(domain.getFirstName());

        return entity;
    }

    public void updateEntity(Advisor domain, org.formation.projet_aida_goumble.adapter.out.persistence.entity.Advisor entity) {
        if (domain == null || entity == null) {
            return;
        }
        entity.setLastName(domain.getLastName());
        entity.setFirstName(domain.getFirstName());
    }
}
