package com.mihalis.springtinder.controlers;

import com.mihalis.springtinder.models.Staffer;
import com.mihalis.springtinder.services.StafferService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
public class StafferController {
    private final StafferService stafferService;

    @PostMapping("/staffer")
    private void save(@RequestBody Staffer staffer) {
        stafferService.save(staffer);
    }

    @GetMapping("/staffer/{id}")
    private @ResponseBody Staffer get(@PathVariable long id) {
        return stafferService.select(id);
    }
}
