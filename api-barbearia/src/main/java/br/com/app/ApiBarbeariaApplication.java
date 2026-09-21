package br.com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.app", "com.barbearia.api"})
@EntityScan(basePackages = "com.barbearia.api.model")
@EnableJpaRepositories(basePackages = "com.barbearia.api.repository")
public class ApiBarbeariaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiBarbeariaApplication.class, args);
    }
}