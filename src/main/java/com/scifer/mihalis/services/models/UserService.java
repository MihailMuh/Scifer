package com.scifer.mihalis.services.models;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService<T> {

    Mono<T> save(T user);

    Flux<T> save(List<T> users);

    Mono<T> get(long id);

    Flux<T> getAll();

    Mono<Void> deleteAll();
}
