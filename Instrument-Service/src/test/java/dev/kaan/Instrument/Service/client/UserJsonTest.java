package dev.kaan.Instrument.Service.client;

import dev.kaan.Instrument.Service.client.Client;
import dev.kaan.Instrument.Service.client.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class UserJsonTest {

    @Autowired
    private JacksonTester<Client> json;

    @Test
    void clientSerializationTest() throws IOException {
        Client client = new Client(1L, 12L,"John", LocalDate.of(2024,11,10), Role.STUDENT);

        assertThat(json.write(client)).isStrictlyEqualToJson("expectedClient.json");
        assertThat(json.write(client)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(client)).extractingJsonPathNumberValue("@.id").isEqualTo(1);
        assertThat(json.write(client)).hasJsonPathNumberValue("@.clientNo");
        assertThat(json.write(client)).extractingJsonPathNumberValue("@.clientNo").isEqualTo(12);
        assertThat(json.write(client)).hasJsonPathStringValue("@.name");
        assertThat(json.write(client)).extractingJsonPathStringValue("@.name").isEqualTo("John");
        assertThat(json.write(client)).hasJsonPathValue("@.createdDate");
        assertThat(json.write(client)).extractingJsonPathStringValue("@.createdDate").isEqualTo("2024-11-10");
        assertThat(json.write(client)).hasJsonPathStringValue("@.role");
        assertThat(json.write(client)).extractingJsonPathStringValue("@.role").isEqualTo("STUDENT");

    }

    @Test
    void clientDeserializationTest() throws IOException {
        String expected = """
                {
                  "id": 1,
                  "clientNo": 12,
                  "name" : "John",
                  "createdDate" : "2024-11-10",
                  "role" : "STUDENT"
                }
                """;

        assertThat(json.parseObject(expected).id).isEqualTo(1);
        assertThat(json.parseObject(expected).clientNo).isEqualTo(12);
        assertThat(json.parseObject(expected).name).isEqualTo("John");
        assertThat(json.parseObject(expected).createdDate).isEqualTo("2024-11-10");
        assertThat(json.parseObject(expected).role).isEqualTo(Role.STUDENT);
    }


}
