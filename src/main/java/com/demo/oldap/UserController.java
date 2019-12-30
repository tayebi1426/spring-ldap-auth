package com.demo.oldap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController("/user")
public class UserController {

    @GetMapping()
    public IicUserDetails user(Principal principal) {
        return (IicUserDetails) principal;
    }
}
