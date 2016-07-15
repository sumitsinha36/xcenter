package com.xcenter.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan("com.xcenter")
public class XCenter extends WebMvcConfigurerAdapter {
	public static void main(String[] args) {
		SpringApplication.run(XCenter.class, args);
	}
}
