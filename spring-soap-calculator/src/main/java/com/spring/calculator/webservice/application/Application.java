package com.spring.calculator.webservice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.spring.soap.webservice.config.SoapConfig;

@SpringBootApplication
@Import(SoapConfig.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		int x;
	}
}
