package org.formation.projet_aida_goumble.application.service;

import jakarta.transaction.Transactional;

import org.formation.projet_aida_goumble.adapter.out.persistence.repository.ClientRepository;
import org.formation.projet_aida_goumble.domain.model.Advisor;
import org.formation.projet_aida_goumble.domain.model.Client;
import org.formation.projet_aida_goumble.domain.port.in.client.*;
import org.formation.projet_aida_goumble.domain.port.out.AdvisorPort;
import org.formation.projet_aida_goumble.domain.port.out.ClientPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService implements CreateClient, UpdateClient, DeleteClient, GetClient, AssignClient {
    private final ClientPort clientPort;
    private final AdvisorPort  advisorPort;
    public ClientService(ClientPort clientPort, AdvisorPort advisorPort) {
        this.clientPort = clientPort;
        this.advisorPort = advisorPort;
    }

    @Override
    public Client createClient(String lastName, String firstName, String address, String phone, String postalCode, String city) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }

        Client client = new Client(lastName, firstName, address, phone, postalCode, city);
        return clientPort.save(client);
    }

    @Override
    public Client updateClient(Long id, String lastName, String firstName, String address, String phone, String postalCode, String city) {
        Client client = clientPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id not found"));

        client.updatePersonalInfo(lastName, firstName, address, phone, postalCode, city);

        return clientPort.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        if (! clientPort.existsById(id)) {
            throw new IllegalArgumentException("Client not found");
        }
        clientPort.deleteById(id);
    }

    @Override
    public Client getClientById(Long id) {
        return clientPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));
    }

    @Override
    public List<Client> getAllClients() {
        return clientPort.findAll();
    }

    @Override
    public List<Client> getClientsByAdvisorId(Long advisorId) {
        return clientPort.findByAdvisorId(advisorId);
    }

    @Override
    public Client assignClientToAdvisor(Long clientId, Long advisorId) {
        Client client = clientPort.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("client not found"));

        Advisor advisor = advisorPort.findById(advisorId)
                .orElseThrow(() -> new IllegalArgumentException("Advisor not found"));

        client. assignToAdvisor(advisorId);

        advisor.addClient(clientId);

        advisorPort.save(advisor);
        return clientPort.save(client);
    }

}
