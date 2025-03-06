package com.seek.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsOriginConfiguration implements WebMvcConfigurer {
  private static final String LOCALHOST = "http://localhost:4200";
  private static final String SEEK_WEB = "http://seek.chichinacds.com.co/";
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOrigins(LOCALHOST, SEEK_WEB)
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(true);
  }
}
