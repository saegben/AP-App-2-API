package org.mastercard.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SuccessController {

    @GetMapping("/account-created")
    public String accountCreated() {
        return "account-created";
    }
}