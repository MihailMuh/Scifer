package com.scifer.mihalis.controllers.storage;

import com.scifer.mihalis.services.storages.PhotoService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ZeroCopyHttpOutputMessage;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.nio.file.Path;

@RestController
@AllArgsConstructor
public class PhotoUploaderController {
    private final PhotoService photoService;

    @GetMapping("/photo/{id}")
    public Mono<Void> downloadPhoto(@PathVariable long id, ServerHttpResponse response) {
        return download(id, response, false);
    }

    @GetMapping("/photo/rec/{id}")
    public Mono<Void> downloadRecPhoto(@PathVariable long id, ServerHttpResponse response) {
        return download(id, response, true);
    }

    private Mono<Void> download(long id, ServerHttpResponse response, boolean isRecPhoto) {
        response.getHeaders().setContentType(MediaType.IMAGE_JPEG);

        Path pathToPhoto = isRecPhoto ? photoService.getPhoto(id) : photoService.getPhotoRec(id);

        ZeroCopyHttpOutputMessage zeroCopyResponse = (ZeroCopyHttpOutputMessage) response;
        return zeroCopyResponse.writeWith(pathToPhoto, 0, pathToPhoto.toFile().length());
    }

    @PostMapping("/photo/{id}")
    public Mono<PackWithUserPhotoPaths> uploadUserPhotos(@RequestPart FilePart photo, @RequestPart FilePart photoRec, @PathVariable long id) {
        return Mono.zip(photoService.savePhoto(photo, id), photoService.savePhotoRec(photoRec, id), (PackWithUserPhotoPaths::new));
    }

    @DeleteMapping("/photo/{id}")
    public void deleteUserPhotos(@PathVariable long id) {
        photoService.deleteAll(id); // non-reactive operation
    }

    private record PackWithUserPhotoPaths(String photo, String photoRec) {
    }
}
