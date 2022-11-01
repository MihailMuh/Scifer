package com.mihalis.springtinder;

import com.mihalis.springtinder.constants.UserType;
import com.mihalis.springtinder.models.Staffer;
import com.mihalis.springtinder.models.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Random;

@Configuration(proxyBeanMethods = false)
class BeansForTests {
    private long randLong() {
        return Math.abs(new Random().nextLong()) / 2;
    }

    @Bean
    public Student getStudent() {
        Student student = new Student();
        student.setId(randLong());
        student.setName("Roman");
        student.setSurname("Parshincev");
        student.setPatronymic("Vitalievich");
        student.setRefsToArticles(new ArrayList<>());
        student.setSpecialization("MATHMECH");
        student.setInterests("StarCraft");
        student.setType(UserType.Postgraduate);
        student.setPhoto("myPhoto");
        student.setPhotoRec("myPhotoRec");
        student.setHash("7a6fa4dff77a228eeda56603b8f53806c");
        student.setAccessToken("533bacf01e11f55b536a565b57531ac114461ae8736d655i7etjyf");

        return student;
    }

    @Bean
    public Staffer getStaffer() {
        Staffer staffer = new Staffer();
        staffer.setId(randLong());
        staffer.setName("Mikhail");
        staffer.setSurname("Mukhortov");
        staffer.setPatronymic("Alekseevich");
        staffer.setRefsToArticles(new ArrayList<>());
        staffer.setSpecialization("MATHMECH");
        staffer.setType(UserType.Mentor);
        staffer.setPosition("Mentor");
        staffer.setPhoto("myPhoto");
        staffer.setPhotoRec("myPhotoRec");
        staffer.setHash("7a6fa4dff77a228eeda56603b8f53806c");
        staffer.setAccessToken("533bacf01e11f55b536a565b57531ac114461ae8736d655i7etjyf");

        return staffer;
    }
}
