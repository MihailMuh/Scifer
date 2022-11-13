package com.mihalis.scifer.services.models;

import com.mihalis.scifer.models.Student;
import com.mihalis.scifer.repositories.models.StudentRepository;
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
    public Mono<Void> deleteAll() {
        return repository.deleteAll();
    }
}
