package com.scifer.mihalis.controllers.users;

import com.scifer.mihalis.configurations.hints.ReflectionHints;
import com.scifer.mihalis.models.Student;
import com.scifer.mihalis.services.models.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@ImportRuntimeHints(ReflectionHints.class)
public class StudentController implements UserController<Student> {
    private final StudentService service;

    @Override
    @PostMapping("/student")
    public Mono<Void> save(@RequestBody Student student) {
        return service.save(student).then();
    }

    @Override
    @GetMapping("/student/{id}")
    public Mono<Student> get(@PathVariable long id) {
        return service.get(id);
    }

    @Override
    @GetMapping("/student")
    public Flux<Student> getAll() {
        return service.getAll();
    }

    @Override
    @DeleteMapping("/student/{id}")
    public Mono<Void> delete(@PathVariable long id) {
        return service.delete(id);
    }
}
