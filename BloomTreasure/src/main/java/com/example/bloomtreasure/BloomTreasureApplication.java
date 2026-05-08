package com.example.bloomtreasure;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BloomTreasureApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloomTreasureApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ClientRepository repository) {
        return (args) -> {
            // 1. Criar um objeto cliente de teste
            Client c1 = new Client();
            c1.setName("Joao Silva");
            c1.setEmail("joao@ubi.pt");
            c1.setNif("123456789");
            c1.setActive("Sim");

            // 2. Guardar no MySQL através do Repository
            repository.save(c1);

            System.out.println("-------------------------------");
            System.out.println("SUCESSO: Cliente guardado na BD!");
            System.out.println("-------------------------------");
        };
    }
}