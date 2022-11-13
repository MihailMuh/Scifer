package com.mihalis.scifer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mihalis.scifer.models.Staffer;
import com.mihalis.scifer.services.models.StafferService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.ArrayList;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class WebTestsForStaffers {
    @Autowired
    private WebTestClient webClient;

    @Autowired
    private StafferService stafferService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSaveStuffer(@Autowired Staffer staffer) {
        stafferService.save(staffer).block();

        webClient.post()
                .uri("/staffer")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(staffer))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testGetStaffer(@Autowired Staffer staffer) {
        stafferService.save(staffer).block();

        webClient.get()
                .uri("/staffer/{id}", staffer.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(Staffer.class).isEqualTo(staffer);
    }

    @Test
    public void testAllStaffers(@Autowired ArrayList<Staffer> staffers) {
        stafferService.deleteAll().block();
        stafferService.save(staffers).blockLast();

        webClient.get()
                .uri("/staffer")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).value(new Consumer<>() {
                    @Override
                    @SneakyThrows
                    public void accept(String resultString) {
                        ArrayList<?> staffersFromDB = objectMapper.readValue(resultString, ArrayList.class);

                        for (int i = 0; i < staffers.size(); i++) {
                            Staffer staffer = objectMapper.readValue(objectMapper.writeValueAsString(staffersFromDB.get(i)), Staffer.class);
                            assertEquals(staffers.get(i).toString(), staffer.toString());
                        }
                    }
                });
    }
}
