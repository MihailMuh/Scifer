package com.scifer.mihalis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SciferMain {
    public static void main(String[] args) {
        SpringApplication.run(SciferMain.class, args);
    }
}
