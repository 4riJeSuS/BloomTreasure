package com.example.bloomtreasure.controller;

import com.example.bloomtreasure.repository.ProductRepository;
import com.example.bloomtreasure.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    // Esta anotação "/" - página principal
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productRepository.findAllByOrderByNameAsc());
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }

    @GetMapping("/category/{id}")
    public String filterByCategory(@PathVariable Long id, Model model) {
        model.addAttribute("products", productRepository.findByCategoryIdCustom(id));
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }
}