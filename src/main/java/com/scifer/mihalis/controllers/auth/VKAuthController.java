package com.scifer.mihalis.controllers.auth;

import com.scifer.mihalis.models.User;
import com.scifer.mihalis.repositories.cache.UserCacheRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@CrossOrigin
public class VKAuthController {
    private final WebClient webClient = WebClient.create();

    private final UserCacheRepository cacheRepository;

    @GetMapping("/get-access")
    private Mono<User> getAccessToken(@RequestParam String code, @Value("${app.secret-key}") String secretKey, @Value("${app.id}") long appId) {
        return webClient.get()
                .uri("https://oauth.vk.com/access_token?client_id=" + appId + "&client_secret=" + secretKey +
                        "&redirect_uri=https://scifer.space/get-access&code=" + code)
                .retrieve()
                .bodyToMono(VKResponse.class)
                .map(this::checkOnErrorResponse)
                .flatMap(this::getUserFromCache);
    }

    private VKResponse checkOnErrorResponse(VKResponse vkResponse) {
        if (vkResponse.error != null) {
            throw new RuntimeException(vkResponse.error_description);
        }
        return vkResponse;
    }

    private Mono<User> getUserFromCache(VKResponse vkResponse) {
        return cacheRepository.get(vkResponse.user_id).map(user -> {
            user.setAccessToken(vkResponse.access_token);

            cacheRepository.delete(user.getId());

            return user;
        });
    }

    private record VKResponse(String access_token, int expires_in, int user_id, String error, String error_description) {
    }
}
