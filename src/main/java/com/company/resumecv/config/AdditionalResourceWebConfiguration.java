package com.company.resumecv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdditionalResourceWebConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:images/");
//        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("/resumes/**").addResourceLocations("file:resumes/");
    }
}
