package com.astro.usersecurity.config;

import com.astro.usersecurity.entity.ERole;
import com.astro.usersecurity.entity.Role;
import com.astro.usersecurity.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.count() == 0) { // check if roles table is empty
                Role adminRole = new Role(ERole.ROLE_ADMIN);
                Role userRole = new Role(ERole.ROLE_USER);
                roleRepository.save(adminRole);
                roleRepository.save(userRole);
                System.out.println("Roles initialized.");
            } else {
                System.out.println("Roles already exist, skipping initialization.");
            }
        };
    }
}
