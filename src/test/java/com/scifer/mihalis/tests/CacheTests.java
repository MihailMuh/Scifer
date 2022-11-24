package com.scifer.mihalis.tests;

import com.scifer.mihalis.BeansForTests;
import com.scifer.mihalis.controllers.cache.UserCacheController;
import com.scifer.mihalis.models.User;
import com.scifer.mihalis.repositories.cache.UserCacheRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

@DirtiesContext
@WebFluxTest(UserCacheController.class)
@Import(BeansForTests.class)
public class CacheTests {
    @MockBean
    private UserCacheRepository cacheRepository;

    @Autowired
    private WebTestClient webClient;

    @Test
    public void shouldSaveUser_toRedis(@Autowired User user) {
        long userId = user.getId();
        Mockito.when(cacheRepository.put(userId, user)).thenReturn(Mono.just(true));

        webClient.post()
                .uri("/cache/user")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(user))
                .exchange()
                .expectStatus()
                .isOk();
    }
}
