package com.scifer.mihalis.controllers.users;

import com.scifer.mihalis.hints.SciferHints;
import com.scifer.mihalis.models.Staffer;
import com.scifer.mihalis.services.models.StafferService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@ImportRuntimeHints(SciferHints.class)
public class StafferController implements UserController<Staffer> {
    private final StafferService stafferService;

    @Override
    @PostMapping("/staffer")
    public void save(@RequestBody Staffer staffer) {
        stafferService.save(staffer);
    }

    @Override
    @GetMapping("/staffer/{id}")
    public Mono<Staffer> get(@PathVariable long id) {
        return stafferService.get(id);
    }

    @Override
    @GetMapping("/staffer")
    public Flux<Staffer> getAll() {
        return stafferService.getAll();
    }
}
