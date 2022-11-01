package com.mihalis.springtinder.services;

import com.mihalis.springtinder.models.Student;
import com.mihalis.springtinder.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StudentService implements UserService<Student> {
    private final StudentRepository repository;

    @Override
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    public void saveAndFlush(Student student) {
        repository.saveAndFlush(student);
    }

    @Override
    public Student getReference(long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Student select(long id) {
        return repository.findById(id).orElse(null);
    }


}
