package org.formation.projet_aida_goumble.service;

import jakarta.transaction.Transactional;
import org.formation.projet_aida_goumble.entity.Client;
import org.formation.projet_aida_goumble.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public Optional<Client> getClientsById(Long id){
        return clientRepository.findById(id);
    }
    @Transactional
    public Client saveClient(Client client){
        clientRepository.save(client);
        return client;
    }
    @Transactional
    public Client deleteClient(Client client){
        clientRepository.delete(client);
        return client;
    }

    @Transactional
    public Client updateClient(Long id, Client client){
        Optional<Client> clientFound = clientRepository.findById(id);
        clientFound.ifPresent(c -> c.setFirstName(client.getFirstName()));
        clientFound.ifPresent(c -> c.setLastName(client.getLastName()));
        clientFound.ifPresent(c -> c.setCity(client.getCity()));
        clientFound.ifPresent(c -> c.setAddress(client.getAddress()));
        clientFound.ifPresent(c -> c.setPostalCode(client.getPostalCode()));
        clientFound.ifPresent(c -> c.setAdvisor(client.getAdvisor()));
        return clientFound.map(clientRepository::save).orElse(null);
    }
}
