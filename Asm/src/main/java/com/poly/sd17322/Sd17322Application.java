package com.poly.sd17322;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Sd17322Application {

    public static void main(String[] args) {
        SpringApplication.run(Sd17322Application.class, args);
    }

}
