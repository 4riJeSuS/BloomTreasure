package com.example.bloomtreasure.repository;

import com.example.bloomtreasure.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository; // Adiciona este import

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findByEmail(String email);
}
