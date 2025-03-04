package com.jeremy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("com.jeremy.repository")
@EntityScan("com.jeremy.model")
@SpringBootApplication
public class JeremySpringCourse {

    public static void main(String[] args) {
        SpringApplication.run(JeremySpringCourse.class, args);
    }
}
