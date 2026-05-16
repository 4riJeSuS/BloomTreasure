package com.example.bloomtreasure.repository;

import com.example.bloomtreasure.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository; // Adiciona este import

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByOrderByNameAsc();

    @Query("SELECT c FROM Category c WHERE c.id_cat = :id")
    List<Category> findAllByIdCustom(@Param("id") Long id);
}
