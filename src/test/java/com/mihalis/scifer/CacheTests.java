package com.mihalis.scifer;

import com.mihalis.scifer.controllers.UserCacheController;
import com.mihalis.scifer.models.User;
import com.mihalis.scifer.repositories.cache.UserCacheRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

@WebFluxTest(UserCacheController.class)
@ExtendWith(SpringExtension.class)
@Import(BeansForTests.class)
public class CacheTests {
    @MockBean
    private UserCacheRepository cacheRepository;

    @Autowired
    private WebTestClient webClient;

    @Test
    public void shouldSaveUser_toRedis(@Autowired @Qualifier("user") User user) {
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
