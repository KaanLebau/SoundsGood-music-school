package dev.kaan.Instrument.Service.client;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientEndPointsTests {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldReturnAClientWhenDataIsSaved(){
        ResponseEntity<Client> response = restTemplate.getForEntity("/clients/1", Client.class);
        Client e = response.getBody();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(e.getId()).isNotNull().isEqualTo(1);
        assertThat(e.getClientNo()).isNotNull().isEqualTo(12);
        assertThat(e.getName()).isNotNull().isEqualTo("Jhon");
        assertThat(e.getCreatedDate()).isNotNull().isEqualTo("2024-11-10");
        assertThat(e.getUpdatedDate()).isNotNull().isEqualTo("2024-11-11");
        assertThat(e.getRole()).isNotNull().isEqualTo(Role.STUDENT);
    }

    @Test
    void shouldNotReturnAClientWithUnknownId(){
        ResponseEntity<Client> response = restTemplate.getForEntity("/clients/99", Client.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }


}
