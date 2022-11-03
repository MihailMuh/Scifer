package com.mihalis.springtinder.services.storages;

import lombok.SneakyThrows;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import static java.util.Objects.requireNonNull;

@Service
public class StorageServiceImpl implements StorageService {
    private final HashMap<Long, Path> paths = new HashMap<>();

    @PostConstruct
    @SneakyThrows(IOException.class)
    private void init() {
        Files.createDirectories(Paths.get("uploads"));
    }

    @Override
    @SneakyThrows(IOException.class)
    public void createDirIfNotExists(long id) {
        if (!paths.containsKey(id)) {
            paths.put(id, Files.createDirectory(Paths.get("uploads/" + id)));
        }
    }

    @Override
    @SneakyThrows(IOException.class)
    public void save(MultipartFile file, long id) {
        createDirIfNotExists(id);
        Files.copy(file.getInputStream(), paths.get(id).resolve(requireNonNull(file.getOriginalFilename())));
    }

    @Override
    public ArrayList<Path> getAll(long id) {
        val filteredPathsById = new ArrayList<Path>();

        paths.forEach((longId, path) -> {
            if (longId == id) {
                filteredPathsById.add(path);
            }
        });

        return filteredPathsById;
    }

    @Override
    public Path get(long id) {
        return paths.get(id);
    }

    @Override
    @SneakyThrows(IOException.class)
    public void deleteAll(long id) {
        FileSystemUtils.deleteRecursively(paths.get(id));
    }
}
