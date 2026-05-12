package com.example.bloomtreasure.repository;

import com.example.bloomtreasure.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository; // Adiciona este import

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> { }
