package com.example.springbootandmvc.services;

import com.example.springbootandmvc.utilities.LogInStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class LoginService {

    private String username;
    private String password;
    private LoggedUserManagementService loggedUserManagementService;

    public LoginService(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    public LogInStatus login() {
        if (loggedUserManagementService.getUsername() == null) {
            if( "natalie".equals(username) && "password".equals(password)) {
                loggedUserManagementService.setUsername(username);
                return LogInStatus.LOGIN_SUCCESS;
            }
            return LogInStatus.LOGIN_FAILED;
        }
        return LogInStatus.ALREADY_LOGGED_IN;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
