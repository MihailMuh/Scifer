package com.mihalis.springtinder.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@CrossOrigin
public interface UserController<T> {
    void save(@RequestBody T user);

    T get(@PathVariable long id);

    List<T> getAll();

    void update(@RequestBody T user);
}
