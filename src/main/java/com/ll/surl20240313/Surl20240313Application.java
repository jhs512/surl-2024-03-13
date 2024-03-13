package com.ll.surl20240313;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Surl20240313Application {

    public static void main(String[] args) {
        SpringApplication.run(Surl20240313Application.class, args);
    }

}
