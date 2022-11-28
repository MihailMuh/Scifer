package com.scifer.mihalis;

import com.scifer.mihalis.constants.UserType;
import com.scifer.mihalis.models.Staffer;
import com.scifer.mihalis.models.Student;
import com.scifer.mihalis.models.User;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.Random;

@TestConfiguration
public class BeansForUserTests {
    public static long randLong() {
        return Math.abs(new Random().nextLong()) / 2;
    }

    @Bean
    @Scope(scopeName = "prototype")
    public Student getStudent() {
        long id = randLong();

        Student student = new Student();
        student.setId(id);
        student.setName("Roman");
        student.setSurname("Parshincev");
        student.setPatronymic("Vitalievich");
        student.setRefsToArticles(new String[]{"hello", "hi"});
        student.setSpecialization("MATHMECH");
        student.setInterests("StarCraft");
        student.setType(UserType.Postgraduate);
        student.setPhoto("/uploads/" + id + "/my_photo.jpg");
        student.setPhotoRec("/uploads/" + id + "/my_photo_small.jpg");
        student.setHash("7a6fa4dff77a228eeda56603b8f53806c");
        student.setAccessToken("533bacf01e11f55b536a565b57531ac114461ae8736d655i7etjyf");

        return student;
    }

    @Bean
    @Scope(scopeName = "prototype")
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            students.add(getStudent());
        }
        return students;
    }

    @Bean
    @Scope(scopeName = "prototype")
    public Staffer getStaffer() {
        long id = randLong();

        Staffer staffer = new Staffer();
        staffer.setId(id);
        staffer.setName("Mikhail");
        staffer.setSurname("Mukhortov");
        staffer.setPatronymic("Alekseevich");
        staffer.setRefsToArticles(new String[]{"hello", "hi"});
        staffer.setSpecialization("MATHMECH");
        staffer.setType(UserType.Mentor);
        staffer.setPosition("Mentor");
        staffer.setPhoto("/uploads/" + id + "/my_photo.jpg");
        staffer.setPhotoRec("/uploads/" + id + "/my_photo_small.jpg");
        staffer.setHash("7a6fa4dff77a228eeda56603b8f53806c");
        staffer.setAccessToken("533bacf01e11f55b536a565b57531ac114461ae8736d655i7etjyf");

        return staffer;
    }

    @Bean
    @Scope(scopeName = "prototype")
    public ArrayList<Staffer> getAllStaffers() {
        ArrayList<Staffer> staffers = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            staffers.add(getStaffer());
        }
        return staffers;
    }

    @Bean(name = "user")
    @Scope(scopeName = "prototype")
    public User getUser() {
        long id = randLong();

        User user = new User();
        user.setId(id);
        user.setName("Roman");
        user.setSurname("Parshincev");
        user.setPatronymic("Vitalievich");
        user.setRefsToArticles(new String[]{"hello", "hi"});
        user.setSpecialization("MATHMECH");
        user.setType(UserType.Postgraduate);
        user.setPhoto("/uploads/" + id + "/my_photo.jpg");
        user.setPhotoRec("/uploads/" + id + "/my_photo_small.jpg");
        user.setHash("7a6fa4dff77a228eeda56603b8f53806c");
        user.setAccessToken("533bacf01e11f55b536a565b57531ac114461ae8736d655i7etjyf");

        return user;
    }
}
