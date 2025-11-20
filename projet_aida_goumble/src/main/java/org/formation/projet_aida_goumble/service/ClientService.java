package org.formation.projet_aida_goumble.service;

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

    public void saveClient(Client client){
        clientRepository.save(client);
    }

    public void deleteClient(Client client){
        clientRepository.delete(client);
    }
}
