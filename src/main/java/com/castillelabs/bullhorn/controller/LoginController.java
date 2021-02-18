package com.castillelabs.bullhorn.controller;

import com.castillelabs.bullhorn.model.Login;
import com.castillelabs.bullhorn.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public void getAuthorizationCode(@RequestBody Login login) {
        loginService.requestAuthorizationCode(login);
    }
}
