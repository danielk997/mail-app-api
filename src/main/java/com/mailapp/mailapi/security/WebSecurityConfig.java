package com.mailapp.mailapi.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig implements WebSecurityCustomizer {

    @Value("${spring.profiles/active:Unknown}")
    private String activeProfile;

    @Override
    public void customize(WebSecurity web) {
        web.ignoring().antMatchers("/**");
    }
}
