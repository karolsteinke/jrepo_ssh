package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan(basePackages = {"processors", "repositories", "services"})
public class ProjectConfig {
    
}
