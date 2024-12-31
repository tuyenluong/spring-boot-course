package com.jeremy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.jeremy.repository.impl", "com.jeremy.services", "com.jeremy.aop"})
@EnableAspectJAutoProxy
public class ProjectConfig {

}
