package com.scifer.mihalis.controllers.auth;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
public class VKAuthController {
    private final WebClient webClient = WebClient.create();

    @PostMapping("/get-access")
    private Mono<String> getAccessToken(@RequestBody String code, @Value("${app.secret-key}") String secretKey,
                                        @Value("${app.id}") long appId, @Value("${spring.cors.origin}") String redirectUrl) {
        return webClient.get()
                .uri("https://oauth.vk.com/access_token?client_id=" + appId + "&client_secret=" + secretKey +
                        "&redirect_uri=" + redirectUrl + "&code=" + code)
                .retrieve()
                .bodyToMono(String.class);
    }
}
