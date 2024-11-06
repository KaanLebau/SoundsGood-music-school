package dev.kaan.Instrument.Service.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService services;


    public ClientController(ClientRepository repository) {

        this.services = new ClientService(repository);
    }

    @GetMapping("/{requestedClientId}")
    private ResponseEntity<Client> findClientById(@PathVariable Long requestedClientId){
        Optional<Client> clientOptional = services.findByClientId(requestedClientId);
        return clientOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/client-no={requestedClientNo}")
    private ResponseEntity<Client> findClientByNo(@PathVariable Long requestedClientNo){
        Optional<Client> clientOptional = services.findByClientNo(requestedClientNo);
        return clientOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    private ResponseEntity<Void> createAClient(@RequestBody Client theClient, UriComponentsBuilder ucb){
        Client createdClient = services.createAClient(theClient);
        URI locationOfNewClient = ucb.path("/clients/{id}").buildAndExpand(createdClient.getId()).toUri();
        return ResponseEntity.created(locationOfNewClient).build();
    }


}
