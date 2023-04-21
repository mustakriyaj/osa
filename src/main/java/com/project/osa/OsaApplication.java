package com.project.osa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class OsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsaApplication.class, args);
	}

}
