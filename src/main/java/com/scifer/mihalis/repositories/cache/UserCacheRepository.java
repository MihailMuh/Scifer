package com.scifer.mihalis.repositories.cache;

import com.scifer.mihalis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class UserCacheRepository {
    private final ReactiveValueOperations<Long, User> cache;

    @Autowired
    public UserCacheRepository(ReactiveRedisOperations<Long, User> reactiveRedis) {
        this.cache = reactiveRedis.opsForValue();
    }

    public Mono<Boolean> put(long id, User user) {
        return cache.set(id, user, Duration.ofHours(12));
    }

    public Mono<User> get(long id) {
        return cache.get(id);
    }

    public void delete(long id) {
        cache.delete(id);
    }
}
