package com.scifer.mihalis.tests;

import com.scifer.mihalis.controllers.storage.PhotoUploaderController;
import com.scifer.mihalis.services.storages.PhotoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import java.util.HashMap;

import static com.scifer.mihalis.BeansForUserTests.randLong;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@DirtiesContext
@WebFluxTest(PhotoUploaderController.class)
public class WebTestsForPhotoUploader {
    @Autowired
    private WebTestClient webClient;

    @MockBean
    private PhotoService photoService;

    private final String photoPath = "/path/on/local/machine/photo.jpg";
    private final String photoRecPath = "/path/on/local/machine/photoRec.jpg";

    private MultiValueMap<String, HttpEntity<?>> getMultipartData() {
        MultipartBodyBuilder multipartBodyBuilder = new MultipartBodyBuilder();
        multipartBodyBuilder.part("photo", new ClassPathResource("best_photo.jpg"), MediaType.MULTIPART_FORM_DATA);
        multipartBodyBuilder.part("photoRec", new ClassPathResource("best_photo.jpg"), MediaType.MULTIPART_FORM_DATA);

        return multipartBodyBuilder.build();
    }

    @Test
    public void shouldUploadUserPhotos_byWebClient() {
        long id = randLong();

        Mockito.when(photoService.savePhoto(any(FilePart.class), eq(id))).thenReturn(Mono.just(photoPath));
        Mockito.when(photoService.savePhotoRec(any(FilePart.class), eq(id))).thenReturn(Mono.just(photoRecPath));

        webClient.post()
                .uri("/photo/{id}", id)
                .body(BodyInserters.fromMultipartData(getMultipartData()))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(HashMap.class)
                .value(json -> {
                    assertEquals(json.get("photo"), photoPath);
                    assertEquals(json.get("photoRec"), photoRecPath);
                });

        Mockito.verify(photoService).savePhoto(any(FilePart.class), eq(id));
        Mockito.verify(photoService).savePhotoRec(any(FilePart.class), eq(id));
    }
}
