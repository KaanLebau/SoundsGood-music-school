package dev.kaan.Instrument.Service.client;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientEndPointsTests {
    @Autowired
    TestRestTemplate restTemplate;
/*
    @Test
    void shouldReturnAClientWhenDataIsSaved(){
        ResponseEntity<Client> response = restTemplate.getForEntity("/clients/1", Client.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        assertThat(id).isNotNull();
        Number clientNo = documentContext.read("$.clientNo");
        assertThat(clientNo).isNotNull();
        String name = documentContext.read("$.name");
        assertThat(name).isNotNull();
        String createdDate = documentContext.read("$.createdDate");
        assertThat(createdDate).isNotNull();
        String role = documentContext.read("$.role");
        assertThat(role).isNotNull();

    }


 */
}
