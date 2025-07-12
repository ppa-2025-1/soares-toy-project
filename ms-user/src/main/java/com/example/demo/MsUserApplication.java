package com.example.demo; // Pacote do ms-user

import com.example.entity.Role;
import com.example.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MsUserApplication {

    private final RoleRepository roleRepository;

    MsUserApplication(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MsUserApplication.class, args);
    }

    @PostConstruct
    void criarRoles() {
        List.of("USER", "GUEST", "VIEWER").forEach(role -> {
            var r = new Role();
            r.setName("ROLE_" + role);
            r.setCreatedAt(LocalDateTime.now());
            r.setUpdatedAt(LocalDateTime.now());
            roleRepository.save(r);
        });
    }
    
    @Bean
    public WebClient webClient() {
        // A URL base para o microsserviço de chamados
        return WebClient.builder().baseUrl("http://localhost:8081").build();
    }
}