package com.scifer.mihalis.services.models;

import com.scifer.mihalis.models.Staffer;
import com.scifer.mihalis.repositories.models.StafferRepository;
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
    public Mono<Staffer> save(Staffer staffer) {
        return repository.save(staffer);
    }

    @Override
    public Flux<Staffer> save(List<Staffer> staffers) {
        return repository.saveAll(staffers);
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
    public Mono<Void> delete(long id) {
        return repository.deleteById(id);
    }
}
