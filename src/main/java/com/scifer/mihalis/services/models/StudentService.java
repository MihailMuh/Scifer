package com.scifer.mihalis.services.models;

import com.scifer.mihalis.models.Student;
import com.scifer.mihalis.repositories.models.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService implements UserService<Student> {
    private final StudentRepository repository;

    @Override
    public Mono<Student> save(Student student) {
        return repository.save(student);
    }

    @Override
    public Flux<Student> save(List<Student> users) {
        return repository.saveAll(users);
    }

    @Override
    public Mono<Student> get(long id) {
        return repository.findById(id);
    }

    @Override
    public Flux<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Void> delete(long id) {
        return repository.deleteById(id);
    }
}
