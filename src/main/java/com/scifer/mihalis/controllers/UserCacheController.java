package com.scifer.mihalis.controllers;

import com.scifer.mihalis.models.User;
import com.scifer.mihalis.repositories.cache.UserCacheRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@AllArgsConstructor
public class UserCacheController {
    private final UserCacheRepository cacheRepository;

    @PostMapping("/cache/user")
    private void saveUserToCache(@RequestBody User user) {
        cacheRepository.put(user.getId(), user);
    }
}