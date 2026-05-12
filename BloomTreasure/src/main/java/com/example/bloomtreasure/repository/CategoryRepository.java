package com.example.bloomtreasure.repository;

import com.example.bloomtreasure.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository; // Adiciona este import

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> { }
