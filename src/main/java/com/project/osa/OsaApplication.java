package com.project.osa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication()
@EnableAutoConfiguration()
@ComponentScan(basePackages = {"com.project.osa", "com.project.osa.controller"})
public class OsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsaApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public WebClient.Builder loadBalancedWebClientbuilder() { return WebClient.builder(); }
}
