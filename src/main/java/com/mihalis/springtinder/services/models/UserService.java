package com.mihalis.springtinder.services.models;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService<T> {

    void save(T user);

    void saveAndFlush(T user);

    void saveAndFlush(List<T> users);

    T getReference(long id);

    T select(long id);

    List<T> getAll();
}
