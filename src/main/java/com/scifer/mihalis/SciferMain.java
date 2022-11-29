package com.scifer.mihalis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAsync
public class SciferMain {
    public static void main(String[] args) {
        SpringApplication.run(SciferMain.class, args);
    }
}
