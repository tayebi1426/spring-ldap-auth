package com.demo.oldap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "com.demo.oldap")
@EnableWebMvc
public class LdapAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(LdapAuthApplication.class, args);
    }
}