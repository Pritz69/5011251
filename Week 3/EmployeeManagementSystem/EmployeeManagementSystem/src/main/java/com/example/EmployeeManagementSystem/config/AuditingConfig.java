package com.example.EmployeeManagementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@SuppressWarnings("unused")
@Configuration
public class AuditingConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        // Return the username of the currently logged-in user
        return () -> Optional.of("admin"); // Replace with your user management logic
    }
}
