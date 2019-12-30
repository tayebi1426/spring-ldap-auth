package com.demo.oldap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.LdapAuthenticator;

//@Configuration
public class CustomLdapAuthProvider {

    @Bean
    public LdapAuthenticationProvider ldapAuthenticationProvider() {
        LdapAuthenticationProvider ldapAuthenticationProvider = new LdapAuthenticationProvider(ldapAuthenticator());
        ldapAuthenticationProvider.setUserDetailsContextMapper(new IicUserDetailsMapper());
        return ldapAuthenticationProvider;
    }

    @Bean
    public LdapAuthenticator ldapAuthenticator() {
        BindAuthenticator bindAuthenticator = new BindAuthenticator(contextSource());
        bindAuthenticator.setUserDnPatterns(new String[]{"uid={0},ou=People"});
        return bindAuthenticator;
    }

    @Bean
    public DefaultSpringSecurityContextSource contextSource() {
        return new DefaultSpringSecurityContextSource("");
    }
}
