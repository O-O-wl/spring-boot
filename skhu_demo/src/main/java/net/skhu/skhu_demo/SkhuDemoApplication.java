package net.skhu.skhu_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"net.skhu"})
@EntityScan("net.skhu.domain")
@EnableJpaRepositories("net.skhu.repository")
public class SkhuDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkhuDemoApplication.class, args);
    }

}

