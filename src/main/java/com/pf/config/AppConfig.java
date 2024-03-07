package com.pf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration
public class AppConfig {

    @Autowired
    private ConfigurableEnvironment env;

    public void setEnvironment(ConfigurableEnvironment env) {
        this.env = env;
    }

    private String profile;

    public String getProfile() {
        return profile;
    }

    @Value("${spring.profiles.active}")
    public void setProfile(String profile) {
        this.profile = profile;
    }
}
