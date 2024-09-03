package com.openlearnhub.ptit.controller;

import com.openlearnhub.ptit.config.KeycloakAdminClientExample;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class TestController {

    private final KeycloakAdminClientExample keycloakAdminClientExample;

    @GetMapping("/test")
    public String test() {
        keycloakAdminClientExample.create();
        return "Hello, world!";
    }
}
