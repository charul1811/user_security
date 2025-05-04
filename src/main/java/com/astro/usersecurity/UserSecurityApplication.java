package com.astro.usersecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.astro.usersecurity.entity")
@EnableJpaRepositories(basePackages = "com.astro.usersecurity.repository")

@SpringBootApplication
public class UserSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run ( UserSecurityApplication.class, args );
    }

}
