package com.mihalis.scifer.controllers.users;

import com.mihalis.scifer.models.Student;
import com.mihalis.scifer.services.models.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Student get(@PathVariable long id) {
        return studentService.select(id);
    }

    @Override
    @GetMapping("/student")
    public List<Student> getAll() {
        return studentService.getAll();
    }
}
