package com.project.osa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication()
@EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)
public class OsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsaApplication.class, args);
	}

}
