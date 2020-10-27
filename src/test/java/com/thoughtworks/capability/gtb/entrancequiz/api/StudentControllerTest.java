package com.thoughtworks.capability.gtb.entrancequiz.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void should_get_student_list() throws Exception {
        mockMvc.perform(get("/student/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(16)));
    }

    @Test
    void should_add_student() throws Exception {
        String newStudent = "张三";

        mockMvc.perform(post("/student/add").content(newStudent).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        mockMvc.perform(get("/student/list"))
                .andExpect(jsonPath("$", hasSize(17)))
                .andExpect(jsonPath("$[16].studentName", is("张三")))
                .andExpect(status().isOk());
    }
}
