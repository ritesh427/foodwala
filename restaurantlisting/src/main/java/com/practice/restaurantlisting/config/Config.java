package com.practice.restaurantlisting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")  // Allow requests from your frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // HTTP methods
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
