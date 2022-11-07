package com.mihalis.springtinder.controllers;

import com.mihalis.springtinder.models.Staffer;
import com.mihalis.springtinder.services.models.StafferService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class StafferController implements UserController<Staffer> {
    private final StafferService stafferService;

    @Override
    @PostMapping("/staffer")
    public void save(@RequestBody Staffer staffer) {
        stafferService.save(staffer);
    }

    @Override
    @GetMapping("/staffer/{id}")
    public Staffer get(@PathVariable long id) {
        return stafferService.select(id);
    }

    @Override
    @GetMapping("/staffer")
    public List<Staffer> getAll() {
        return stafferService.getAll();
    }

    @Override
    @PutMapping("/staffer")
    public void update(Staffer staffer) {
        stafferService.save(staffer);
    }
}
