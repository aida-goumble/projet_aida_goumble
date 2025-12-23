package org.formation.projet_aida_goumble.adapter.out.persistence.mapper;

import org.formation.projet_aida_goumble.domain.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public Client toDomain(org.formation.projet_aida_goumble.adapter.out.persistence.entity.Client  entity) {
        if (entity == null) {
            return null;
        }

        Long advisorId = entity.getAdvisor() != null ? entity.getAdvisor().getId() : null;

        return new Client(
                entity.getId(),
                entity.getLastName(),
                entity.getFirstName(),
                entity.getAddress(),
                entity. getPhone(),
                entity.getPostalCode(),
                entity. getCity(),
                advisorId
        );
    }

    public org.formation.projet_aida_goumble.adapter.out.persistence.entity.Client toEntity(Client domain) {
        if (domain == null) {
            return null;
        }

        org.formation.projet_aida_goumble.adapter.out.persistence.entity.Client entity = new org.formation.projet_aida_goumble.adapter.out.persistence.entity.Client();
        entity.setId(domain. getId());
        entity.setLastName(domain.getLastName());
        entity.setFirstName(domain.getFirstName());
        entity.setAddress(domain.getAddress());
        entity.setPhone(domain.getPhone());
        entity.setPostalCode(domain.getPostalCode());
        entity.setCity(domain.getCity());

        return entity;
    }

    public void updateEntity(Client domain, org.formation.projet_aida_goumble.adapter.out.persistence.entity.Client entity) {
        if (domain == null || entity == null) {
            return;
        }

        entity.setLastName(domain.getLastName());
        entity.setFirstName(domain.getFirstName());
        entity.setAddress(domain.getAddress());
        entity.setPhone(domain.getPhone());
        entity.setPostalCode(domain.getPostalCode());
        entity.setCity(domain.getCity());
    }
}
