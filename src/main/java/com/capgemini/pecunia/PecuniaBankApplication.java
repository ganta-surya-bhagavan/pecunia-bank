package com.capgemini.pecunia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.capgemini.pecunia")
public class PecuniaBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(PecuniaBankApplication.class, args);
	}

}
