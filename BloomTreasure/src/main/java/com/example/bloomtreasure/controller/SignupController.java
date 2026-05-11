package com.example.bloomtreasure.controller;

import com.example.bloomtreasure.Client;
import com.example.bloomtreasure.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/signup")
    public String registerClient(@ModelAttribute Client client) {
        // Preenchemos os campos automáticos que não vêm do formulário
        client.setRole("USER"); // Por padrão, quem se regista no site é User
        client.setActive("YES"); // Ou o valor que usares para indicar conta ativa

        // Guarda na base de dados
        clientRepository.save(client);

        // Redireciona para o login após sucesso
        return "redirect:/login?success";
    }
}
