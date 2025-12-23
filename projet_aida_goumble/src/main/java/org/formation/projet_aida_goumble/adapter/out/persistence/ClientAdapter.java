package org.formation.projet_aida_goumble.adapter.out.persistence;

import org.formation.projet_aida_goumble.adapter.out.persistence.mapper.ClientMapper;
import org.formation.projet_aida_goumble.adapter.out.persistence.repository.AdvisorRepository;
import org.formation.projet_aida_goumble.adapter.out.persistence.repository.ClientRepository;
import org.formation.projet_aida_goumble.domain.model.Client;
import org.formation.projet_aida_goumble.domain.port.out.ClientPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClientAdapter implements ClientPort {
    private final ClientRepository clientRepository;
    private final AdvisorRepository advisorRepository;
    private final ClientMapper mapper;

    public ClientAdapter(ClientRepository clientRepository,
                                    AdvisorRepository advisorRepository,
                                    ClientMapper mapper) {
        this.clientRepository = clientRepository;
        this.advisorRepository = advisorRepository;
        this.mapper = mapper;
    }

    @Override
    public Client save(Client client) {
        org.formation.projet_aida_goumble.adapter.out.persistence.entity.Client entity;

        if (client. getId() != null) {
            entity = clientRepository.findById(client.getId())
                    .orElse(mapper.toEntity(client));
            mapper.updateEntity(client, entity);
        } else {
            entity = mapper. toEntity(client);
        }

        if (client.getAdvisorId() != null) {
            org.formation.projet_aida_goumble.adapter.out.persistence.entity.Advisor advisor = advisorRepository.findById(client.getAdvisorId())
                    .orElse(null);
            entity.setAdvisor(advisor);
        }

        org.formation.projet_aida_goumble.adapter.out.persistence.entity.Client saved = clientRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository. findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository. findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Client> findByAdvisorId(Long advisorId) {
        return clientRepository.findByAdvisorId(advisorId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return clientRepository.existsById(id);
    }
}
