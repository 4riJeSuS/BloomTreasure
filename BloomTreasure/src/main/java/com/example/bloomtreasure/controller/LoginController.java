package com.example.bloomtreasure.controller;


import com.example.bloomtreasure.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
