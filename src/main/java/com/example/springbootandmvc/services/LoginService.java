package com.example.springbootandmvc.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
@AllArgsConstructor
public class LoginService {

    private String username;
    private String password;

    public boolean login() {
        return "natalie".equals(username) && "password".equals(password);
    }
}
