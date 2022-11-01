package com.mihalis.springtinder.services;

import org.springframework.stereotype.Service;

@Service
public interface UserService<T> {

    void save(T user);

    void saveAndFlush(T user);

    T getReference(long id);

    T select(long id);
}
