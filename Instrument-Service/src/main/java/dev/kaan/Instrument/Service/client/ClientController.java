package dev.kaan.Instrument.Service.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/clients")
public class ClientController {
    
    @GetMapping("/{id}")
    private ResponseEntity<Client> findClientById(@PathVariable Long id){
        Client client = new Client(1L, 12L,"John", LocalDate.of(2024,11,10), Role.STUDENT);
        return ResponseEntity.ok(client);
    } 
}
