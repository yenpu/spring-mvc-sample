package com.example.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcSampleApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringMvcSampleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcSampleApplication.class, args);
    }
}
