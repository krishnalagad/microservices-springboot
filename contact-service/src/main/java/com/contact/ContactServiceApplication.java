package com.contact;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ContactServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("contact-service started...");
	}

}
