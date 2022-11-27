package com.scifer.mihalis.tests;

import com.scifer.mihalis.BeansForTests;
import com.scifer.mihalis.controllers.users.StafferController;
import com.scifer.mihalis.models.Staffer;
import com.scifer.mihalis.services.models.StafferService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

import static com.scifer.mihalis.UserAssertions.assertStaffer;

@DirtiesContext
@WebFluxTest(StafferController.class)
@Import(BeansForTests.class)
public class WebTestsForStaffers {
    @Autowired
    private WebTestClient webClient;

    @MockBean
    private StafferService stafferService;

    @Test
    public void shouldSaveStaffer_byWebClient(@Autowired Staffer staffer) {
        Mockito.when(stafferService.save(staffer)).thenReturn(Mono.just(staffer));

        webClient.post()
                .uri("/staffer")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(staffer)
                .exchange()
                .expectStatus()
                .isOk();

        Mockito.verify(stafferService).save(staffer);
    }

    @Test
    public void shouldGetStaffer_fromWebClient(@Autowired Staffer staffer) {
        long id = staffer.getId();

        Mockito.when(stafferService.get(id)).thenReturn(Mono.just(staffer));

        webClient.get()
                .uri("/staffer/{id}", id)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Staffer.class)
                .value(stafferFromResponse -> assertStaffer(stafferFromResponse, id, staffer.getName()));

        Mockito.verify(stafferService).get(id);
    }

    @Test
    public void shouldGetAllListOfStaffer_fromWebClient(@Autowired ArrayList<Staffer> staffers) {
        Mockito.when(stafferService.getAll()).thenReturn(Flux.fromIterable(staffers));

        webClient.get()
                .uri("/staffer")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(Staffer.class)
                .hasSize(staffers.size())
                .value(staffersFromResponse -> {
                    for (int i = 0; i < staffers.size(); i++) {
                        assertStaffer(staffersFromResponse.get(i), staffers.get(i).getId(), staffers.get(i).getName());
                    }
                });

        Mockito.verify(stafferService).getAll();
    }
}
