package com.mihalis.springtinder;

import com.mihalis.springtinder.services.storages.StorageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;

import static com.mihalis.springtinder.BeansForTests.randLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestFileUploader {
    private long id;

    private MockMultipartFile photo;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StorageService storageService;

    @BeforeEach
    public void uploadPhoto() throws Exception {
        photo = new MockMultipartFile("photo", "myPhoto.jpg", "image/png", "My Best Photo".getBytes());
        id = randLong();

        mockMvc.perform(multipart("/photo/{id}", id).file(photo))
                .andExpect(status().isOk());
    }

    @Test
    public void testUploadPhoto() {
        then(storageService).should().save(photo, id);
    }

    @Test
    public void testDownloadPhoto() throws Exception {
        given(storageService.getAsResource(id)).willReturn(photo.getResource());

        MvcResult result = mockMvc.perform(get("/photo/{id}", id))
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photo.getResource().getFilename() + "\""))
                .andReturn();

        Assertions.assertEquals(Arrays.toString(result.getResponse().getContentAsByteArray()), Arrays.toString(photo.getBytes()));
    }
}
