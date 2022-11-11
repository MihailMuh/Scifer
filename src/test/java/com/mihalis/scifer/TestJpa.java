package com.mihalis.scifer;

import com.mihalis.scifer.constants.UserType;
import com.mihalis.scifer.models.Staffer;
import com.mihalis.scifer.models.Student;
import com.mihalis.scifer.services.models.StafferService;
import com.mihalis.scifer.services.models.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Transactional
class TestJpa {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StafferService stafferService;

    @Test
    public void testStudent(@Autowired Student student) {
        studentService.saveAndFlush(student);

        long id = student.getId();

        testStudentOnCorrectString(student, id, student.getName());
        testStudentOnCorrectString(studentService.getReference(id), id, student.getName());

        student.setName("BLABLABLA");

        studentService.saveAndFlush(student);
        student = studentService.select(id);

        testStudentOnCorrectString(student, id, "BLABLABLA");
    }

    private void testStudentOnCorrectString(Student student, long id, String name) {
        assertEquals(student.getId(), id);
        assertEquals(student.getName(), name);
        assertEquals(student.getSurname(), "Parshincev");
        assertEquals(student.getPatronymic(), "Vitalievich");
        assertEquals(student.getRefsToArticles(), new ArrayList<>());
        assertEquals(student.getSpecialization(), "MATHMECH");
        assertEquals(student.getType(), UserType.Postgraduate);
        assertEquals(student.getInterests(), "StarCraft");
        assertEquals(student.getPhoto(), "/uploads/" + id + "/my_photo.jpg");
        assertEquals(student.getPhotoRec(), "/uploads/" + id + "/my_photo_small.jpg");
        assertEquals(student.getHash(), "7a6fa4dff77a228eeda56603b8f53806c");
        assertEquals(student.getAccessToken(), "533bacf01e11f55b536a565b57531ac114461ae8736d655i7etjyf");
    }

    @Test
    public void testStaff(@Autowired Staffer staffer) {
        stafferService.saveAndFlush(staffer);

        long id = staffer.getId();

        testScientistOnCorrectString(staffer, id, staffer.getName());
        testScientistOnCorrectString(stafferService.getReference(id), id, staffer.getName());

        staffer.setName("BLABLABLA");

        stafferService.saveAndFlush(staffer);
        staffer = stafferService.select(id);

        testScientistOnCorrectString(staffer, id, "BLABLABLA");
    }

    private void testScientistOnCorrectString(Staffer staffer, long id, String name) {
        assertEquals(staffer.getId(), id);
        assertEquals(staffer.getName(), name);
        assertEquals(staffer.getSurname(), "Mukhortov");
        assertEquals(staffer.getPatronymic(), "Alekseevich");
        assertEquals(staffer.getRefsToArticles(), new ArrayList<>());
        assertEquals(staffer.getSpecialization(), "MATHMECH");
        assertEquals(staffer.getType(), UserType.Mentor);
        assertEquals(staffer.getPosition(), "Mentor");
        assertNull(staffer.getAcademicDegree());
        assertNull(staffer.getAcademicTitle());
        assertNull(staffer.getRefsToQualifyingWorks());
        assertEquals(staffer.getPhoto(), "/uploads/" + id + "/my_photo.jpg");
        assertEquals(staffer.getPhotoRec(), "/uploads/" + id + "/my_photo_small.jpg");
        assertEquals(staffer.getHash(), "7a6fa4dff77a228eeda56603b8f53806c");
        assertEquals(staffer.getAccessToken(), "533bacf01e11f55b536a565b57531ac114461ae8736d655i7etjyf");
    }
}
