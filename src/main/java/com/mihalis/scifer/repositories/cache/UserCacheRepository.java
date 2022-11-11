package com.mihalis.scifer.repositories.cache;

import com.mihalis.scifer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserCacheRepository {
    private static final String USER_HASH_MAP_KEY = "USERS";
    private final HashOperations<String, Long, User> cache;

    @Autowired
    public UserCacheRepository(RedisTemplate<String, User> cache) {
        this.cache = cache.opsForHash();
    }

    public void put(long id, User user) {
        cache.put(USER_HASH_MAP_KEY, id, user);
    }

    public User get(long id) {
        return cache.get(USER_HASH_MAP_KEY, id);
    }

    public void delete(long id) {
        cache.delete(USER_HASH_MAP_KEY, id);
    }
}
