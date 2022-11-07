package com.mihalis.springtinder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mihalis.springtinder.models.Staffer;
import com.mihalis.springtinder.models.Student;
import com.mihalis.springtinder.services.models.StafferService;
import com.mihalis.springtinder.services.models.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class TestMvc {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StafferService stafferService;

    @Autowired
    private Student student;

    @Autowired
    private Staffer staffer;

    @Test
    public void testSaveStudent() throws Exception {
        mockMvc.perform(post("/student")
                        .content(objectMapper.writeValueAsString(student))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetStudent(@Autowired Student student) throws Exception {
        studentService.saveAndFlush(student);

        MvcResult result = mockMvc.perform(get("/student/{id}", student.getId()))
                .andExpect(status().isOk())
                .andReturn();

        Student studentFromDB = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
        assertEquals(student.toString(), studentFromDB.toString());
    }

    @Test
    public void testUpdateStudent() throws Exception {
        testSaveStudent();

        student.setName("BLABLABLA");

        mockMvc.perform(put("/student")
                        .content(objectMapper.writeValueAsString(student))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testAllStudents(@Autowired ArrayList<Student> students) throws Exception {
        studentService.saveAndFlush(students);

        MvcResult result = mockMvc.perform(get("/student"))
                .andExpect(status().isOk())
                .andReturn();

        ArrayList<?> studentsFromDB = objectMapper.readValue(result.getResponse().getContentAsString(), ArrayList.class);

        for (int i = 0; i < students.size(); i++) {
            Student student = objectMapper.readValue(objectMapper.writeValueAsString(studentsFromDB.get(i)), Student.class);
            assertEquals(students.get(i).toString(), student.toString());
        }
    }

    @Test
    public void testSaveStuffer() throws Exception {
        mockMvc.perform(post("/staffer")
                        .content(objectMapper.writeValueAsString(staffer))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetStaffer(@Autowired Staffer staffer) throws Exception {
        stafferService.saveAndFlush(staffer);

        MvcResult result = mockMvc.perform(get("/staffer/{id}", staffer.getId()))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());

        Staffer stafferFromDB = objectMapper.readValue(result.getResponse().getContentAsString(), Staffer.class);
        assertEquals(staffer.toString(), stafferFromDB.toString());
    }

    @Test
    public void testUpdateStuffer() throws Exception {
        testSaveStuffer();

        staffer.setName("BLABLABLA");

        mockMvc.perform(put("/staffer")
                        .content(objectMapper.writeValueAsString(staffer))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testAllStaffers(@Autowired ArrayList<Staffer> staffers) throws Exception {
        stafferService.saveAndFlush(staffers);

        MvcResult result = mockMvc.perform(get("/staffer"))
                .andExpect(status().isOk())
                .andReturn();

        ArrayList<?> staffersFromDB = objectMapper.readValue(result.getResponse().getContentAsString(), ArrayList.class);

        for (int i = 0; i < staffers.size(); i++) {
            Staffer staffer = objectMapper.readValue(objectMapper.writeValueAsString(staffersFromDB.get(i)), Staffer.class);
            assertEquals(staffers.get(i).toString(), staffer.toString());
        }
    }
}
