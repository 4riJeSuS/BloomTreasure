package com.example.bloomtreasure.controller;

import com.example.bloomtreasure.Client;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin/dashboard")
    public String dashboard(HttpSession session) {
        Client user = (Client) session.getAttribute("loggedUser");

        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/login";
        }
        return "admin_dashboard";
    }
}
