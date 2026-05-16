package com.example.bloomtreasure.controller;

import com.example.bloomtreasure.Client;
import com.example.bloomtreasure.Product;
import com.example.bloomtreasure.repository.CategoryRepository;
import com.example.bloomtreasure.repository.ProductRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/products")
public class ProductAdminController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String listProducts(Model model, HttpSession session) {
        Client user = (Client) session.getAttribute("loggedUser");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/login";
        }

        model.addAttribute("products", productRepository.findAll());
        return "admin/products_list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, HttpSession session) {
        Client user = (Client) session.getAttribute("loggedUser");
        if (user != null && "ADMIN".equals(user.getRole())) {
            productRepository.deleteById(id);
        }
        return "redirect:/admin/products";
    }

    @GetMapping("/new")
    public String showNewProductForm(Model model, HttpSession session) {
        Client user = (Client) session.getAttribute("loggedUser");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/login";
        }

        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryRepository.findAll());
        return "admin/products_form";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model, HttpSession session) {
        Client user = (Client) session.getAttribute("loggedUser");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/login";
        }

        java.util.Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            model.addAttribute("categories", categoryRepository.findAll());
            return "admin/products_form";
        }
        return "redirect:/admin/products";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product, HttpSession session) {
        Client user = (Client) session.getAttribute("loggedUser");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/login";
        }
        productRepository.save(product);
        return "redirect:/admin/products";
    }
}
