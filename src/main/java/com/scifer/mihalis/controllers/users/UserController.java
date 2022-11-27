package com.scifer.mihalis.controllers.users;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
public interface UserController<T> {
    Mono<Void> save(@RequestBody T user);

    Mono<T> get(@PathVariable long id);

    Flux<T> getAll();
}
