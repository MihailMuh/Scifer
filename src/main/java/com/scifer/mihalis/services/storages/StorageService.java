package com.scifer.mihalis.services.storages;

import lombok.SneakyThrows;
import org.springframework.util.FileSystemUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public abstract class StorageService {
    protected final HashMap<Long, Path> dirs = new HashMap<>();

    private final String baseStorageDir;

    protected StorageService(String baseStorageDir) {
        this.baseStorageDir = baseStorageDir;

        createMissingDirectories();
    }

    protected final Path getPhotoDir() {
        return Path.of(baseStorageDir);
    }

    @SneakyThrows(IOException.class)
    private void createMissingDirectories() {
        Path photoDir = getPhotoDir();
        if (Files.notExists(photoDir)) {
            Files.createDirectories(photoDir);
        }
    }

    @SneakyThrows(IOException.class)
    protected void createDirIfNotExists(long id) {
        if (!dirs.containsKey(id)) {
            dirs.put(id, Files.createDirectory(Paths.get(baseStorageDir + id)));
        }
    }

    @SneakyThrows(IOException.class)
    public void deleteAll(long id) {
        FileSystemUtils.deleteRecursively(dirs.get(id));
    }
}
