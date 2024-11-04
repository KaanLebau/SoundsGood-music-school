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
    
    @GetMapping("/{requestedClientId}")
    private ResponseEntity<Client> findClientById(@PathVariable Long requestedClientId){
        if(requestedClientId.equals(1L)){
            Client client = Client.builder().id(1L).clientNo(12L).name("Jhon").role(Role.STUDENT).createdDate(LocalDate.of(2024,11,10)).updatedDate(LocalDate.of(2024,11,11)).build();
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
