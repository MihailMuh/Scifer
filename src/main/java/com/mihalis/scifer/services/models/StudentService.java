package com.mihalis.scifer.services.models;

import com.mihalis.scifer.models.Student;
import com.mihalis.scifer.repositories.models.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public void saveAndFlush(List<Student> users) {
        repository.saveAllAndFlush(users);
    }

    @Override
    public Student getReference(long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Student select(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }
}
