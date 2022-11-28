package com.scifer.mihalis.tests;

import com.scifer.mihalis.BeansForUserTests;
import com.scifer.mihalis.controllers.users.StudentController;
import com.scifer.mihalis.models.Student;
import com.scifer.mihalis.services.models.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

import static com.scifer.mihalis.UserAssertions.assertStudent;

@DirtiesContext
@WebFluxTest(StudentController.class)
@Import(BeansForUserTests.class)
public class WebTestsForStudents {
    @Autowired
    private WebTestClient webClient;

    @MockBean
    private StudentService studentService;

    @Test
    public void shouldSaveStudent_byWebClient(@Autowired Student student) {
        Mockito.when(studentService.save(student)).thenReturn(Mono.just(student));

        webClient.post()
                .uri("/student")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(student))
                .exchange()
                .expectStatus()
                .isOk();

        Mockito.verify(studentService).save(student);
    }

    @Test
    public void shouldGetStudent_fromWebClient(@Autowired Student student) {
        long id = student.getId();

        Mockito.when(studentService.get(id)).thenReturn(Mono.just(student));

        webClient.get()
                .uri("/student/{id}", student.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(Student.class)
                .value(studentFromResponse -> assertStudent(studentFromResponse, id, student.getName()));

        Mockito.verify(studentService).get(id);
    }

    @Test
    public void shouldGetAllListOfStaffer_fromWebClient(@Autowired ArrayList<Student> students) {
        Mockito.when(studentService.getAll()).thenReturn(Flux.fromIterable(students));

        webClient.get()
                .uri("/student")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Student.class)
                .hasSize(students.size())
                .value(studentsFromResponse -> {
                    for (int i = 0; i < students.size(); i++) {
                        assertStudent(studentsFromResponse.get(i), students.get(i).getId(), students.get(i).getName());
                    }
                });

        Mockito.verify(studentService).getAll();
    }
}
