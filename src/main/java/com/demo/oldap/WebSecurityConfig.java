package com.demo.oldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthServerConfigProps configProps;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .anyRequest().permitAll()//.fullyAuthenticated()
                ;//.and().httpBasic();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication()
                .userDetailsContextMapper(userDetailsContextMapper())
                .userDnPatterns(configProps.getUserDnPatterns())
                .contextSource().url(configProps.getProviderUrl());
    }

    @Bean
    public UserDetailsContextMapper userDetailsContextMapper() {
        return new IicUserDetailsMapper();
    }
}