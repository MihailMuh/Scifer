package com.mihalis.scifer.services.models;

import com.mihalis.scifer.models.Staffer;
import com.mihalis.scifer.repositories.models.StafferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@AllArgsConstructor
public class StafferService implements UserService<Staffer> {
    private final StafferRepository repository;

    @Override
    public Mono<Staffer> save(Staffer user) {
        return repository.save(user);
    }

    @Override
    public Flux<Staffer> save(List<Staffer> users) {
        return repository.saveAll(users);
    }

    @Override
    public Mono<Staffer> get(long id) {
        return repository.findById(id);
    }

    @Override
    public Flux<Staffer> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Void> deleteAll() {
        return repository.deleteAll();
    }
}
