package com.scifer.mihalis;

import com.scifer.mihalis.constants.UserType;
import com.scifer.mihalis.models.Staffer;
import com.scifer.mihalis.models.Student;

import static org.junit.jupiter.api.Assertions.*;

public class StringAssertions {
    public static void assertStaffer(Staffer staffer, long id, String stafferName) {
        assertEquals(staffer.getId(), id);
        assertEquals(staffer.getName(), stafferName);
        assertEquals(staffer.getSurname(), "Mukhortov");
        assertEquals(staffer.getPatronymic(), "Alekseevich");
        assertArrayEquals(staffer.getRefsToArticles(), new String[]{"hello", "hi"});
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

    public static void assertStudent(Student student, long id, String studentName) {
        assertEquals(student.getId(), id);
        assertEquals(student.getName(), studentName);
        assertEquals(student.getSurname(), "Parshincev");
        assertEquals(student.getPatronymic(), "Vitalievich");
        assertArrayEquals(student.getRefsToArticles(), new String[]{"hello", "hi"});
        assertEquals(student.getSpecialization(), "MATHMECH");
        assertEquals(student.getType(), UserType.Postgraduate);
        assertEquals(student.getInterests(), "StarCraft");
        assertEquals(student.getPhoto(), "/uploads/" + id + "/my_photo.jpg");
        assertEquals(student.getPhotoRec(), "/uploads/" + id + "/my_photo_small.jpg");
        assertEquals(student.getHash(), "7a6fa4dff77a228eeda56603b8f53806c");
        assertEquals(student.getAccessToken(), "533bacf01e11f55b536a565b57531ac114461ae8736d655i7etjyf");
    }
}
