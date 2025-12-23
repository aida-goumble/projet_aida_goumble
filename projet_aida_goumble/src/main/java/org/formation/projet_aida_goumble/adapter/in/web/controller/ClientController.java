package org.formation.projet_aida_goumble.adapter.in.web.controller;

import org.formation.projet_aida_goumble.adapter.in.web.dto.AssignClientToAdvisorRequest;
import org.formation.projet_aida_goumble.adapter.in.web.dto.ClientDto;
import org.formation.projet_aida_goumble.adapter.in.web.dto.CreateClientRequest;
import org.formation.projet_aida_goumble.adapter.in.web.dto.UpdateClientRequest;
import org.formation.projet_aida_goumble.adapter.in.web.mapper.ClientDtoMapper;
import org.formation.projet_aida_goumble.application.service.ClientService;
import org.formation.projet_aida_goumble.domain.model.Client;
import org.formation.projet_aida_goumble.domain.port.in.client.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final CreateClient createClient;
    private final UpdateClient updateClient;
    private final DeleteClient deleteClient;
    private final GetClient getClient;
    private final AssignClient assignClient;
    private final ClientDtoMapper mapper;

    public ClientController(CreateClient createClient, UpdateClient updateClient, DeleteClient deleteClient, GetClient getClient, AssignClient assignClient, ClientDtoMapper mapper) {
        this.createClient = createClient;
        this.updateClient = updateClient;
        this.deleteClient = deleteClient;
        this.getClient = getClient;
        this.assignClient = assignClient;
        this.mapper = mapper;
    }


    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody CreateClientRequest request) {
        Client client = createClient.createClient(
                request.getLastName(),
                request.getFirstName(),
                request.getAddress(),
                request.getPhone(),
                request.getPostalCode(),
                request.getCity()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(client));
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAllClients() {
        List<ClientDto> clients = getClient.getAllClients().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id) {
        Client client = getClient. getClientById(id);
        return ResponseEntity.ok(mapper.toDto(client));
    }

    @GetMapping("/by-advisor/{advisorId}")
    public ResponseEntity<List<ClientDto>> getClientsByAdvisor(@PathVariable Long advisorId) {
        List<ClientDto> clients = getClient. getClientsByAdvisorId(advisorId).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(clients);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable Long id,
                                                  @RequestBody UpdateClientRequest request) {
        Client client = updateClient.updateClient(
                id,
                request.getLastName(),
                request.getFirstName(),
                request.getAddress(),
                request.getPhone(),
                request.getPostalCode(),
                request.getCity()
        );
        return ResponseEntity.ok(mapper.toDto(client));
    }

    @PutMapping("/{id}/assign-advisor")
    public ResponseEntity<ClientDto> assignClientToAdvisor(@PathVariable Long id,
                                                           @RequestBody AssignClientToAdvisorRequest request) {
        Client client = assignClient.assignClientToAdvisor(id, request.getAdvisorId());
        return ResponseEntity.ok(mapper.toDto(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        deleteClient.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
