package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan({"com.example.demo.database"})
@ComponentScan({"com.example.demo.Controller"})
@SpringBootApplication
public class TestShopeeApplication  extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TestShopeeApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(TestShopeeApplication.class, args);
	}

}
