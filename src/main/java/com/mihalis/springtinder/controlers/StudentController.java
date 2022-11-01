package com.mihalis.springtinder.controlers;

import com.mihalis.springtinder.models.Student;
import com.mihalis.springtinder.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    private @ResponseBody Student get(@PathVariable long id) {
        return studentService.select(id);
    }
}
