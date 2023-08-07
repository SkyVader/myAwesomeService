package com.test.awesome.service;

import org.springframework.stereotype.Component;

@Component
public class SecurityService {

    public String currentUser() {
        return "User1";
    }
}
