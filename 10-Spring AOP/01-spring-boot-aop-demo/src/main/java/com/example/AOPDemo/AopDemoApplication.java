package com.example.AOPDemo;

import com.example.AOPDemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO){

		return runner -> {
			demoTheBeforeAdvice(accountDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO) {

		// call the business method
		accountDAO.addAccount();

		// let's call it again
		System.out.println("\nlet's call it again");
		accountDAO.addAccount();

		// and again
		System.out.println("\nand again");
		accountDAO.addAccount();
	}
}
