package com.demo.oldap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.ldap")
public class AuthServerConfigProps {

    private String providerUrl;
    private String userDnPatterns;

    public String getProviderUrl() {
        return providerUrl;
    }

    public void setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
    }

    public String getUserDnPatterns() {
        return userDnPatterns;
    }

    public void setUserDnPatterns(String userDnPatterns) {
        this.userDnPatterns = userDnPatterns;
    }
}
