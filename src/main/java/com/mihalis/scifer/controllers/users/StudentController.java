package com.mihalis.scifer.controllers.users;

import com.mihalis.scifer.models.Student;
import com.mihalis.scifer.services.models.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
public class StudentController implements UserController<Student> {
    private final StudentService studentService;

    @Override
    @PostMapping("/student")
    public void save(@RequestBody Student student) {
        studentService.save(student);
    }

    @Override
    @GetMapping("/student/{id}")
    public Mono<Student> get(@PathVariable long id) {
        return studentService.get(id);
    }

    @Override
    @GetMapping("/student")
    public Flux<Student> getAll() {
        return studentService.getAll();
    }
}
