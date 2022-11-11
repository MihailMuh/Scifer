package com.mihalis.scifer.controllers;

import com.mihalis.scifer.models.User;
import com.mihalis.scifer.repositories.cache.UserCacheRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@AllArgsConstructor
@RestController
@CrossOrigin
public class VKAuthController {
    private final UserCacheRepository cacheRepository;

    @GetMapping("/get-access")
    private void getAccessByCode(@RequestParam String code, @Value("${app.secret-key}") String secretKey, @Value("${app.id}") long appId) {
        new RestTemplate().getForEntity("https://oauth.vk.com/access_token?client_id="
                + appId + "&client_secret=" + secretKey + "&redirect_uri=http://scifer.space/get-access&code=" + code, String.class);
    }

    @PostMapping("/get-access")
    private User getFullyAccess(@RequestBody HashMap<String, ?> json) {
        if (json.containsKey("error")) {
            throw new RuntimeException(json.toString());
        }

        User user = cacheRepository.get((Long) json.get("user_id"));
        user.setAccessToken((String) json.get("access_token"));

        cacheRepository.delete(user.getId());

        return user;
    }
}
