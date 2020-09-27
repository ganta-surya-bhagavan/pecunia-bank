package com.capgemini.pecunia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class PecuniaBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(PecuniaBankApplication.class, args);
	}

}
