package com.mihalis.springtinder.controlers;

import com.mihalis.springtinder.services.storages.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@AllArgsConstructor
public class FileUploadController {
    private final StorageService storageService;

    @GetMapping("/photo/{id}")
    public ResponseEntity<Resource> downloadPhoto(@PathVariable long id) {
        Resource photo = storageService.getAsResource(id);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + photo.getFilename() + "\"").body(photo);
    }

    @PostMapping("/photo/{id}")
    public void uploadPhoto(@RequestParam MultipartFile photo, @PathVariable long id) {
        storageService.save(photo, id);
    }
}
