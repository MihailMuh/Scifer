package com.mihalis.scifer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mihalis.scifer.models.Student;
import com.mihalis.scifer.services.models.StudentService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.ArrayList;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class WebTestsForStudents {
    @Autowired
    private WebTestClient webClient;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSaveStudent(@Autowired Student student) {
        studentService.save(student).block();

        webClient.post()
                .uri("/student")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(student))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testGetStudent(@Autowired Student student) {
        studentService.save(student).block();

        webClient.get()
                .uri("/student/{id}", student.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(Student.class).isEqualTo(student);
    }

    @Test
    public void testAllStudents(@Autowired ArrayList<Student> students) {
        studentService.deleteAll().block();
        studentService.save(students).blockLast();

        webClient.get()
                .uri("/student")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).value(new Consumer<>() {
                    @Override
                    @SneakyThrows
                    public void accept(String resultString) {
                        ArrayList<?> studentsFromDB = objectMapper.readValue(resultString, ArrayList.class);

                        for (int i = 0; i < students.size(); i++) {
                            Student student = objectMapper.readValue(objectMapper.writeValueAsString(studentsFromDB.get(i)), Student.class);
                            assertEquals(students.get(i).toString(), student.toString());
                        }
                    }
                });
    }
}
