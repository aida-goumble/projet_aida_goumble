package org.formation.projet_aida_goumble.adapter.in.web.mapper;

import org.formation.projet_aida_goumble.adapter.in.web. dto.ManagerDto;
import org.formation.projet_aida_goumble.domain.model.Manager;
import org.springframework.stereotype.Component;

@Component
public class ManagerDtoMapper {

    public ManagerDto toDto(Manager domain) {
        if (domain == null) {
            return null;
        }

        return new ManagerDto(
                domain.getId(),
                domain.getLastName(),
                domain.getFirstName(),
                domain.getAdvisorIds()
        );
    }
}