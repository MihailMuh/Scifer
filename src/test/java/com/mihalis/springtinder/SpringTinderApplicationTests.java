package com.mihalis.springtinder;

import com.mihalis.springtinder.models.Student;
import com.mihalis.springtinder.services.MainService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@SpringBootTest
@Transactional
class SpringTinderApplicationTests {
    @Autowired
    private MainService mainService;

    @Test
    public void testStudent() {
        Student student = new Student();
        student.setId(1);
        student.setName("Roman");
        student.setSurname("Parshincev");
        student.setPatronymic("Vitalievich");
        student.setRefsToArticles(new ArrayList<>());
        student.setSpecialization("MATHMECH");
        student.setInterests("StarCraft");

        mainService.save(student);

        testStudentOnCorrectString(student);
        testStudentOnCorrectString(mainService.getStudent(1));
    }

    private void testStudentOnCorrectString(Student student) {
        Assertions.assertEquals(student.toString(), "Student(super=User(id=1, name=Roman, surname=Parshincev, patronymic=Vitalievich, specialization=MATHMECH, refsToArticles=[], type=2), interests=StarCraft)");
    }
}
