package dev.east0.demo_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"dev.east0"})
@EntityScan("dev.east0.domain")
@EnableJpaRepositories("dev.east0.repository")
public class DemoApiSkhuApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApiSkhuApplication.class, args);
    }

}

