package org.formation.projet_aida_goumble.adapter.in.web.mapper;

import org.formation. projet_aida_goumble.adapter.in.web.dto.AdvisorDto;
import org.formation.projet_aida_goumble.domain.model.Advisor;
import org. springframework.stereotype.Component;

@Component
public class AdvisorDtoMapper {

    public AdvisorDto toDto(Advisor domain) {
        if (domain == null) {
            return null;
        }

        return new AdvisorDto(
                domain.getId(),
                domain. getLastName(),
                domain. getFirstName(),
                domain. getManagerId(),
                domain.getClientIds()
        );
    }
}