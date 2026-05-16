package com.example.bloomtreasure.controller;

import com.example.bloomtreasure.Category;
import com.example.bloomtreasure.Client;
import com.example.bloomtreasure.repository.CategoryRepository;
import com.example.bloomtreasure.repository.ProductRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/categories")
public class CategoryAdminController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String listCategories(Model model, HttpSession session) {
        Client user = (Client) session.getAttribute("loggedUser");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/login";
        }

        model.addAttribute("categories", categoryRepository.findAllByOrderByNameAsc());
        return "admin/categories_list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id, HttpSession session) {
        Client user = (Client) session.getAttribute("loggedUser");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/login"; // Expulsa se não for Admin
        }

        try {
            categoryRepository.deleteById(id);
        } catch (Exception e) {
            // Evita que a app rebente se a categoria tiver produtos associados
            System.out.println("Erro ao eliminar categoria: " + e.getMessage());
        }
        return "redirect:/admin/categories";
    }

    @GetMapping("/new")
    public String newCategory(Model model, HttpSession session) {
        Client user = (Client) session.getAttribute("loggedUser");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/login";
        }

        model.addAttribute("category", new Category());
        return "admin/categories_form";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable Long id, Model model, HttpSession session) {
        Client user = (Client) session.getAttribute("loggedUser");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/login";
        }

        java.util.Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "admin/categories_form";
        }
        return "redirect:/admin/categories";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("category") Category category, HttpSession session) {
        Client user = (Client) session.getAttribute("loggedUser");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/login";
        }

        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }
}
