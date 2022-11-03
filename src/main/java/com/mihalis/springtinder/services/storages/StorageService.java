package com.mihalis.springtinder.services.storages;

import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.ArrayList;

public interface StorageService {
    void createDirIfNotExists(long id);

    void save(MultipartFile file, long id);

    ArrayList<Path> getAll(long id);

    Path get(long id);

    @SneakyThrows(MalformedURLException.class)
    default Resource getAsResource(long id) {
        return new UrlResource(get(id).toUri());
    }

    void deleteAll(long id);
}
