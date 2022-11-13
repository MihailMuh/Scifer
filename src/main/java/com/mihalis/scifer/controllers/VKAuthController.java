package com.mihalis.scifer.controllers;

import com.mihalis.scifer.models.User;
import com.mihalis.scifer.repositories.cache.UserCacheRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@AllArgsConstructor
@RestController
@CrossOrigin
public class VKAuthController {
    private final WebClient webClient = WebClient.create("https://oauth.vk.com");
    private final UserCacheRepository cacheRepository;

    @GetMapping("/get-access")
    private void getAccessByCode(@RequestParam String code, @Value("${app.secret-key}") String secretKey, @Value("${app.id}") long appId) {
        webClient.get()
                .uri("/access_token?client_id=" + appId + "&client_secret=" + secretKey + "&redirect_uri=https://scifer.space/get-access&code=" + code)
                .retrieve();
    }

    @PostMapping("/get-access")
    private Mono<User> getFullyAccess(@RequestBody HashMap<String, ?> json) {
        if (json.containsKey("error")) {
            throw new RuntimeException(json.toString());
        }

        return cacheRepository.get((Long) json.get("user_id")).map(user -> {
            user.setAccessToken((String) json.get("access_token"));

            cacheRepository.delete(user.getId());

            return user;
        });
    }
}
