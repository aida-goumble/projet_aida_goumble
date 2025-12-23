package org.formation.projet_aida_goumble.adapter.in.web.mapper;

import org.formation.projet_aida_goumble.adapter.in.web. dto.ClientDto;
import org.formation.projet_aida_goumble.domain.model. Client;
import org.springframework. stereotype.Component;

@Component
public class ClientDtoMapper {

    public ClientDto toDto(Client domain) {
        if (domain == null) {
            return null;
        }

        return new ClientDto(
                domain. getId(),
                domain.getLastName(),
                domain.getFirstName(),
                domain.getAddress(),
                domain.getPhone(),
                domain.getPostalCode(),
                domain.getCity(),
                domain.getAdvisorId()
        );
    }
}
