package com.jeremy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Using WebMvcConfingurer to handle dynamic page
    // which will not handle any business logic
    // other than parsing the html page and Thymeleaf syntax
    // then you can use this method addViewControllers of WebMvcConfigurer
    // to handle this scenario

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/courses").setViewName("courses");
        registry.addViewController("/about").setViewName("about");
    }

}
