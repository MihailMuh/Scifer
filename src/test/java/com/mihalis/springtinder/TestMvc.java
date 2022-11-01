package com.mihalis.springtinder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mihalis.springtinder.models.Staffer;
import com.mihalis.springtinder.models.Student;
import com.mihalis.springtinder.services.StafferService;
import com.mihalis.springtinder.services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @Test
    public void testSaveStudent(@Autowired Student student) throws Exception {
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
    public void testSaveStuffer(@Autowired Staffer staffer) throws Exception {
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

        Staffer stafferFromDB = objectMapper.readValue(result.getResponse().getContentAsString(), Staffer.class);
        assertEquals(staffer.toString(), stafferFromDB.toString());
    }
}
