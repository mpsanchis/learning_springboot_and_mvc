package com.example.springbootandmvc.controllers;

import com.example.springbootandmvc.services.LoginService;
import com.example.springbootandmvc.utilities.LogInStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {

        loginService.setUsername(username);
        loginService.setPassword(password);
        var loggStatus = loginService.login();

        if (loggStatus == LogInStatus.ALREADY_LOGGED_IN) {
            return "redirect:/logged-home";
        }
        else if (loggStatus == LogInStatus.LOGIN_SUCCESS) {
            return "redirect:/logged-home";
        } else if (loggStatus == LogInStatus.LOGIN_FAILED) {
            model.addAttribute("message", "Login failed!");
        }
        return "login.html";
    }
}
