package com.mihalis.springtinder.services;

import com.mihalis.springtinder.models.Staffer;
import com.mihalis.springtinder.repositories.StafferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StafferService implements UserService<Staffer> {
    private final StafferRepository repository;

    @Override
    public void save(Staffer staffer) {
        repository.save(staffer);
    }

    @Override
    public void saveAndFlush(Staffer staffer) {
        repository.saveAndFlush(staffer);
    }

    @Override
    public Staffer getReference(long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Staffer select(long id) {
        return repository.findById(id).orElse(null);
    }
}
