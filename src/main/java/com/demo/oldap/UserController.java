package com.demo.oldap;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

    @GetMapping()
    public IicUserDetails user() {
        return (IicUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
