package com.mihalis.scifer.controllers.users;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@CrossOrigin
public interface UserController<T> {
    void save(@RequestBody T user);

    Mono<T> get(@PathVariable long id);

    Flux<T> getAll();
}
