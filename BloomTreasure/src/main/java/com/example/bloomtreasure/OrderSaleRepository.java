package com.example.bloomtreasure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository; // Adiciona este import

@Repository
public interface OrderSaleRepository extends CrudRepository<OrderSale, Long> { }
