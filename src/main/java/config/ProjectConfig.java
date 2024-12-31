package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"repository.impl", "services", "aop"})
@EnableAspectJAutoProxy
public class ProjectConfig {

}
