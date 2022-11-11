package com.mihalis.scifer.services.models;

import java.util.List;

public interface UserService<T> {

    void save(T user);

    void saveAndFlush(T user);

    void saveAndFlush(List<T> users);

    T getReference(long id);

    T select(long id);

    List<T> getAll();
}
