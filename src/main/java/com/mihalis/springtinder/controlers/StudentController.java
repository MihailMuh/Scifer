package com.mihalis.springtinder.controlers;

import com.mihalis.springtinder.models.Student;
import com.mihalis.springtinder.services.models.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/student")
    private void save(@RequestBody Student student) {
        studentService.save(student);
    }

    @GetMapping("/student/{id}")
    private Student get(@PathVariable long id) {
        return studentService.select(id);
    }

    @GetMapping("/student")
    private List<Student> getAll() {
        return studentService.getAll();
    }
}
