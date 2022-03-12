package ru.skipp.autopartstore;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.skipp.autopartstore.repository.UserRepository;


@SpringBootApplication
public class AutoPartStoreApplication  {

	public static void main(String[] args) {
		SpringApplication.run(AutoPartStoreApplication.class, args);
	}
}
