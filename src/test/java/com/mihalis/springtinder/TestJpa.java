package com.mihalis.springtinder;

import com.mihalis.springtinder.constants.UserType;
import com.mihalis.springtinder.models.Staffer;
import com.mihalis.springtinder.models.Student;
import com.mihalis.springtinder.services.StafferService;
import com.mihalis.springtinder.services.StudentService;
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

        testStudentOnCorrectString(student, id);
        testStudentOnCorrectString(studentService.getReference(id), id);
    }

    private void testStudentOnCorrectString(Student student, long id) {
        assertEquals(student.getId(), id);
        assertEquals(student.getName(), "Roman");
        assertEquals(student.getSurname(), "Parshincev");
        assertEquals(student.getPatronymic(), "Vitalievich");
        assertEquals(student.getRefsToArticles(), new ArrayList<>());
        assertEquals(student.getSpecialization(), "MATHMECH");
        assertEquals(student.getType(), UserType.Postgraduate);
        assertEquals(student.getInterests(), "StarCraft");
        assertEquals(student.getPhoto(), "myPhoto");
        assertEquals(student.getPhotoRec(), "myPhotoRec");
        assertEquals(student.getHash(), "7a6fa4dff77a228eeda56603b8f53806c");
        assertEquals(student.getAccessToken(), "533bacf01e11f55b536a565b57531ac114461ae8736d655i7etjyf");
    }

    @Test
    public void testStaff(@Autowired Staffer staffer) {
        stafferService.saveAndFlush(staffer);

        long id = staffer.getId();

        testMentorOnCorrectString(staffer, id);
        testMentorOnCorrectString(stafferService.getReference(id), id);
    }

    private void testMentorOnCorrectString(Staffer staffer, long id) {
        assertEquals(staffer.getId(), id);
        assertEquals(staffer.getName(), "Mikhail");
        assertEquals(staffer.getSurname(), "Mukhortov");
        assertEquals(staffer.getPatronymic(), "Alekseevich");
        assertEquals(staffer.getRefsToArticles(), new ArrayList<>());
        assertEquals(staffer.getSpecialization(), "MATHMECH");
        assertEquals(staffer.getType(), UserType.Mentor);
        assertEquals(staffer.getPosition(), "Mentor");
        assertNull(staffer.getAcademicDegree());
        assertNull(staffer.getAcademicTitle());
        assertNull(staffer.getRefsToQualifyingWorks());
        assertEquals(staffer.getPhoto(), "myPhoto");
        assertEquals(staffer.getPhotoRec(), "myPhotoRec");
        assertEquals(staffer.getHash(), "7a6fa4dff77a228eeda56603b8f53806c");
        assertEquals(staffer.getAccessToken(), "533bacf01e11f55b536a565b57531ac114461ae8736d655i7etjyf");
    }
}
