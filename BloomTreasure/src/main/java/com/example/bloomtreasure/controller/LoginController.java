package com.example.bloomtreasure.controller;


import com.example.bloomtreasure.Client;
import com.example.bloomtreasure.repository.ClientRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email, @RequestParam String password, HttpSession session) {
        Client client = clientRepository.findByEmail(email);

        if (client != null && client.getPassword().equals(password)) {
            session.setAttribute("loggedUser", client);
            if ("ADMIN".equals(client.getRole())) {
                return "redirect:/admin/dashboard";
            } else {
                return "redirect:/";
            }
        }
        return "redirect:/login?error=true";
    }
}
