package org.formation.projet_aida_goumble.controller;

import org.formation.projet_aida_goumble.entity.Client;
import org.formation.projet_aida_goumble.entity.Manager;
import org.formation.projet_aida_goumble.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client")
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @PostMapping("/client")
    public Client createClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        return clientService.getClientsById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/client/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {

        return clientService.updateClient(id, client);
    }

    @DeleteMapping("/client")
    public Client deleteClient(@RequestBody Client client) {
        return clientService.deleteClient(client);
    }
}
