package dev.east0.skhu_student_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"dev.east0"})
@EntityScan("dev.east0.domain")
@EnableJpaRepositories("dev.east0.repository")
public class SkhuStudentDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkhuStudentDemoApplication.class, args);
    }

}

