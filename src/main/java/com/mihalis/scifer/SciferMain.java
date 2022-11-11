package com.mihalis.scifer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAsync
public class SciferMain {
    public static void main(String[] args) {
        SpringApplication.run(SciferMain.class, args);
    }

    @GetMapping("/")
    private String root() {
        return "This is the best application in the world!";
    }
}
