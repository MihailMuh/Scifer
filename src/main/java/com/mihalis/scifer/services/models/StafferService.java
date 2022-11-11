package com.mihalis.scifer.services.models;

import com.mihalis.scifer.models.Staffer;
import com.mihalis.scifer.repositories.models.StafferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public void saveAndFlush(List<Staffer> users) {
        repository.saveAllAndFlush(users);
    }

    @Override
    public Staffer getReference(long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Staffer select(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Staffer> getAll() {
        return repository.findAll();
    }
}
