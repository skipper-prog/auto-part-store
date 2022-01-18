package ru.skipp.autopartstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AutoPartStoreApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AutoPartStoreApplication.class, args);
	}

}
