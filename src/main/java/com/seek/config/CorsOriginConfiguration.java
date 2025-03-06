package com.seek.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CorsOriginConfiguration implements WebMvcConfigurer {
  private static final String LOCALHOST = "http://localhost:4200";
  private static final String VMC_CHICHINACDS_HTTP = "http://www.vmc.chichinacds.com.co";
  private static final String VMC_CHICHINACDS_HTTPS = "https://www.vmc.chichinacds.com.co";
  private static final String VMC_CHICHINACDS_HTTPS_I = "http://vmc.chichinacds.com.co";
  private static final String VMC_CHICHINACDS_HTTPS_II= "https://vmc.chichinacds.com.co";
  private static final String VMC_AEX= "http://aex.com.co";
  private static final String VMC_AEXs= "httpS://aex.com.co";
  private static final String VMC_local= "http://localhost:7777";
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOrigins(LOCALHOST, VMC_CHICHINACDS_HTTP, VMC_CHICHINACDS_HTTPS, VMC_CHICHINACDS_HTTPS_I, VMC_CHICHINACDS_HTTPS_II, VMC_AEX, VMC_AEXs, VMC_local)
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(true);
  }
}
