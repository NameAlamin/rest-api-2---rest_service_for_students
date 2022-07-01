package com.rest2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@ComponentScan(basePackages = {"com.rest2.controllers"})
public class ServletConfig implements WebMvcConfigurer {
    @Override
   public void configureViewResolvers(ViewResolverRegistry registry){
        registry.jsp("/WEB-INF/views/", ".jsp");
    }
}
