package com.scifer.mihalis.services.storages;

import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static com.scifer.mihalis.constants.FoldersPath.BASE_PHOTO_DIR;

@Service
public class PhotoService extends StorageService {
    public PhotoService() {
        super(BASE_PHOTO_DIR);
    }

    @PostConstruct
    @SneakyThrows(IOException.class)
    private void init() {
        try (Stream<Path> iteratedDirs = Files.walk(getPhotoDir(), 1)) {
            iteratedDirs
                    .parallel()
                    .filter(Files::isDirectory)
                    .forEach(dir -> {
                        try {
                            dirs.put(Long.parseLong(dir.getFileName().toString()), dir);
                        } catch (NumberFormatException exception) {
                            System.out.println("Cannot identify directory: " + dir.getFileName().toString() + " - skipping!");
                        }
                    });
        }
    }

    private Mono<String> save(FilePart photo, long id, String filename) {
        createDirIfNotExists(id);

        Path destinationPhoto = dirs.get(id).resolve(filename).normalize();

        return Mono.ignoreElements(photo.transferTo(destinationPhoto)).thenReturn(destinationPhoto.toString());
    }

    public Mono<String> savePhotoRec(FilePart photo, long id) {
        return save(photo, id, "photoRec.jpg");
    }

    public Mono<String> savePhoto(FilePart photo, long id) {
        return save(photo, id, "photo.jpg");
    }

    public Path getPhoto(long id) {
        return get(id, "photo.jpg");
    }

    public Path getPhotoRec(long id) {
        return get(id, "photoRec.jpg");
    }

    private Path get(long id, String filename) {
        return dirs.get(id).resolve(filename);
    }
}
