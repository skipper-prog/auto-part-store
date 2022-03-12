package ru.skipp.autopartstore;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.skipp.autopartstore.repository.UserRepository;


@SpringBootApplication
public class AutoPartStoreApplication implements ApplicationRunner {
	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AutoPartStoreApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		//System.out.println(userRepository.findAll());
		System.out.println(userRepository.findByLastNameContainingIgnoreCase("last"));
		System.out.println(userRepository.findByEmailIgnoreCase("admin@javaops.ru"));
	}

	public AutoPartStoreApplication(UserRepository userRepository){
		this.userRepository = userRepository;
	}

}
