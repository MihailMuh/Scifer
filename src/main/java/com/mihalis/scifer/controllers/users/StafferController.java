package com.mihalis.scifer.controllers.users;

import com.mihalis.scifer.models.Staffer;
import com.mihalis.scifer.services.models.StafferService;
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
}
