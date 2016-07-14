package com.xcenter.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.xcenter")
public class XCenter {
	public static void main(String[] args) {
		SpringApplication.run(XCenter.class, args);
	}
}
