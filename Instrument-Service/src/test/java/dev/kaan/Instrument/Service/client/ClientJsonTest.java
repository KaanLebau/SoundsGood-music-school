package dev.kaan.Instrument.Service.client;

import net.bytebuddy.asm.Advice;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class ClientJsonTest {

    @Autowired
    private JacksonTester<Client> json;

    @Autowired
    private JacksonTester<Client[]> jsonList;
    private Client[] clientList;

    @BeforeEach
    void setUp(){
        clientList = Arrays.array(
                Client.builder().id(0L).clientNo(0L).name("Admin").createdDate(LocalDate.of(2023, 10 ,10)).updatedDate(LocalDate.of(2023, 10,21)).role(Role.ADMIN).build(),
                Client.builder().id(1L).clientNo(12L).name("Jhon").createdDate(LocalDate.of(2024,11,10)).updatedDate(LocalDate.of(2024,11,11)).role(Role.STUDENT).build(),
                Client.builder().id(2L).clientNo(232L).name("Jane").createdDate(LocalDate.of(2024,9,10)).updatedDate(LocalDate.of(2024,9,11)).role(Role.STUDENT).build(),
                Client.builder().id(3L).clientNo(1242L).name("Josh").createdDate(LocalDate.of(2024, 1,10)).updatedDate(LocalDate.of(2024,10,11)).role(Role.STUDENT).build(),
                Client.builder().id(4L).clientNo(1215L).name("Ken").createdDate(LocalDate.of(2024, 2,10)).updatedDate(LocalDate.of(2024,07,11)).role(Role.STUDENT).build(),
                Client.builder().id(5L).clientNo(13122L).name("Joleen").createdDate(LocalDate.of(2024,11,10)).updatedDate(LocalDate.of(2024,11,11)).role(Role.STUDENT).build(),
                Client.builder().id(11L).clientNo(1312L).name("Galadreal").createdDate(LocalDate.of(2024,11,10)).updatedDate(LocalDate.of(2024,11,11)).role(Role.STUDENT).build(),
                Client.builder().id(12L).clientNo(145112L).name("Sara").createdDate(LocalDate.of(2024,11,10)).updatedDate(LocalDate.of(2024,11,11)).role(Role.STUDENT).build(),
                Client.builder().id(13L).clientNo(1551222L).name("Olof").createdDate(LocalDate.of(2024,11,10)).updatedDate(LocalDate.of(2024,11,11)).role(Role.STUDENT).build()
        );
    }



    @Test
    void clientSerializationTest() throws IOException {
        Client client = Client.builder()
                .id(1L)
                .createdDate(LocalDate.of(2024, 11, 10))
                .updatedDate(LocalDate.of(2024, 11, 11))
                .clientNo(12L)
                .name("John")
                .role(Role.STUDENT)
                .build();

        assertThat(json.write(client)).isStrictlyEqualToJson("expectedClient.json");
        assertThat(json.write(client)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(client)).extractingJsonPathNumberValue("@.id").isEqualTo(1);
        assertThat(json.write(client)).hasJsonPathNumberValue("@.clientNo");
        assertThat(json.write(client)).extractingJsonPathNumberValue("@.clientNo").isEqualTo(12);
        assertThat(json.write(client)).hasJsonPathStringValue("@.name");
        assertThat(json.write(client)).extractingJsonPathStringValue("@.name").isEqualTo("John");
        assertThat(json.write(client)).hasJsonPathValue("@.createdDate");
        assertThat(json.write(client)).extractingJsonPathStringValue("@.createdDate").isEqualTo("2024-11-10");
        assertThat(json.write(client)).hasJsonPathValue("@.updatedDate");
        assertThat(json.write(client)).extractingJsonPathStringValue("@.updatedDate").isEqualTo("2024-11-11");
        assertThat(json.write(client)).hasJsonPathStringValue("@.role");
        assertThat(json.write(client)).extractingJsonPathStringValue("@.role").isEqualTo("STUDENT");

    }



    @Test
    void clientDeserializationTest() throws IOException {
        String expected = """
                {
             
                    "id": 1,
                    "clientNo": 12,
                    "name": "John",
                    "createdDate": "2024-11-10",
                    "updatedDate": "2024-11-11",
                    "role": "STUDENT"
                }
                """;

        assertThat(json.parseObject(expected).getId()).isEqualTo(1);
        assertThat(json.parseObject(expected).clientNo).isEqualTo(12);
        assertThat(json.parseObject(expected).name).isEqualTo("John");
        assertThat(json.parseObject(expected).getCreatedDate()).isEqualTo("2024-11-10");
        assertThat(json.parseObject(expected).getUpdatedDate()).isEqualTo("2024-11-11");
        assertThat(json.parseObject(expected).role).isEqualTo(Role.STUDENT);
    }






}
