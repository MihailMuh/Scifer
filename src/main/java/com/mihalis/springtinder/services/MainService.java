package com.mihalis.springtinder.services;

import com.mihalis.springtinder.models.Student;
import com.mihalis.springtinder.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    private final StudentRepository studentRepository;

    @Autowired
    public MainService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> userList() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student getStudent(long id) {
        return studentRepository.getReferenceById(id);
    }
}
