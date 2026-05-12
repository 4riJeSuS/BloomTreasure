package com.example.bloomtreasure.repository;

import com.example.bloomtreasure.ItemOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository; // Adiciona este import

@Repository
public interface ItemOrderRepository extends CrudRepository<ItemOrder, Long> { }
