package sk.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

//enable OpenFeign clients and tell where to search for the proxy contracts

@Configuration
@EnableFeignClients(basePackages = "sk.proxy")
public class ProjectConfig {
}
