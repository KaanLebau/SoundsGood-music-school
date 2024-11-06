package dev.kaan.Instrument.Service.client;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.net.URI;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ClientEndPointsTests {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldReturnAClientWhenDataIsSaved(){
        ResponseEntity<Client> response = restTemplate.getForEntity("/clients/1", Client.class);
        Client clientToCheck = response.getBody();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        clientCheck(clientToCheck);
    }

    @Test
    void shouldReturnAClientWithClientNo(){
        ResponseEntity<Client> response = restTemplate.getForEntity("/clients/client-no=11", Client.class);
        Client clientToCheck = response.getBody();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        clientCheck(clientToCheck);
    }


    @Test
    void shouldNotReturnAClientWithUnknownId(){
        ResponseEntity<Client> response = restTemplate.getForEntity("/clients/99", Client.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void shouldNotReturnAClientWithUnknownClientNo(){
        ResponseEntity<Client> response = restTemplate.getForEntity("/clinets/client-no=1212", Client.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void shouldCreateAClient(){
        // POST request shold not return anything but location of new created entity should have a location that reserved for this entity
        // checking that location is exist the same as entity have saved.
        Client client = Client.builder()
                .id(null)
                .clientNo(11L)
                .name("Jane")
                .role(Role.STUDENT)
                .createdDate(LocalDate.of(2024,11,10))
                .updatedDate(null).build();
        ResponseEntity<Void> response = restTemplate.postForEntity("/clients", client, Void.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        URI locationOfNewClient = response.getHeaders().getLocation();
        ResponseEntity<String> clientLocation = restTemplate.getForEntity(locationOfNewClient, String.class);
        assertThat(clientLocation.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    void clientCheck(Client clientToCheck){
        assertThat(clientToCheck).isNotNull();
        assertThat(clientToCheck.getId()).isNotNull().isEqualTo(1);
        assertThat(clientToCheck.getClientNo()).isNotNull().isEqualTo(11);
        assertThat(clientToCheck.getName()).isNotNull().isEqualTo("Jane");
        assertThat(clientToCheck.getCreatedDate()).isNotNull().isEqualTo("2024-11-10");
        assertThat(clientToCheck.getUpdatedDate()).isNull();
        assertThat(clientToCheck.getRole()).isNotNull().isEqualTo(Role.STUDENT);
    }


}
