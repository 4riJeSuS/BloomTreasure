package com.example.bloomtreasure.controller;

import com.example.bloomtreasure.repository.ProductRepository;
import com.example.bloomtreasure.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Esta anotação "/" faz com que esta seja a página principal
    @GetMapping("/")
    public String index(Model model) {
        // Envia os produtos e categorias da base de dados para o HTML
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }
}