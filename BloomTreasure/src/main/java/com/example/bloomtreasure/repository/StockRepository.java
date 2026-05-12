package com.example.bloomtreasure.repository;

import com.example.bloomtreasure.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository; // Adiciona este import

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> { }

