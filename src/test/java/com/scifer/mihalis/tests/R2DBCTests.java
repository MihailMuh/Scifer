package com.scifer.mihalis.tests;

import com.scifer.mihalis.BeansForUserTests;
import com.scifer.mihalis.models.Staffer;
import com.scifer.mihalis.models.Student;
import com.scifer.mihalis.services.models.StafferService;
import com.scifer.mihalis.services.models.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;

import static com.scifer.mihalis.UserAssertions.assertStaffer;
import static com.scifer.mihalis.UserAssertions.assertStudent;

@SpringBootTest
@DirtiesContext
@Import(BeansForUserTests.class)
class R2DBCTests {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StafferService stafferService;

    @Test
    public void testStudent(@Autowired final Student student) {
        long id = student.getId();

        studentService.save(student).subscribe(savedStudent ->
                assertStudent(savedStudent, id, student.getName()));

        assertStudent(student, id, student.getName());

        student.setName("BLABLABLA");

        studentService.save(student).subscribe(savedStudent ->
                assertStudent(savedStudent, id, "BLABLABLA"));
    }

    @Test
    public void testStaff(@Autowired final Staffer staffer) {
        long id = staffer.getId();

        stafferService.save(staffer).subscribe(savedStaffer ->
                assertStaffer(savedStaffer, id, staffer.getName()));

        assertStaffer(staffer, id, staffer.getName());

        staffer.setName("BLABLABLA");

        stafferService.save(staffer).subscribe(savedStaffer ->
                assertStaffer(savedStaffer, id, "BLABLABLA"));
    }
}
