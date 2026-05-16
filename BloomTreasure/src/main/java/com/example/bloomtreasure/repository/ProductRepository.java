package com.example.bloomtreasure.repository;

import com.example.bloomtreasure.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByNameAsc();

    @Query("SELECT p FROM Product p WHERE p.category.id_cat = :id")
    List<Product> findByCategoryIdCustom(@Param("id") Long id);
}