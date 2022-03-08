package com.example.springbootandmvc.controllers;

import com.example.springbootandmvc.services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {

        var loginService = new LoginService(username, password);
        boolean loggedIn = loginService.login();

        if (loggedIn) {
            model.addAttribute("message", "You are now logged in :)");
        } else {
            model.addAttribute("message", "Login failed!");
        }
        return "login.html";
    }
}
