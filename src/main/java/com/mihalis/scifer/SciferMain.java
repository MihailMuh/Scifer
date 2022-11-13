package com.mihalis.scifer;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SciferMain {
    public static void main(String[] args) {
        SpringApplication.run(SciferMain.class, args);
    }

    @GetMapping("/")
    private String root() {
        return "This is the best application in the world!";
    }

    @Bean
    public ConnectionFactoryInitializer connectionFactoryInitializer(@Autowired ConnectionFactory connectionFactory,
                                                                     @Value("${spring.r2dbc.ddl-auto}") String scheme) {
        var initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);

        var populator = new CompositeDatabasePopulator();
        populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource(scheme + ".sql")));

        initializer.setDatabasePopulator(populator);

        return initializer;
    }
}
