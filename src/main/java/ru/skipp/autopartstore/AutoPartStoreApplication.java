package ru.skipp.autopartstore;

import lombok.AllArgsConstructor;
import ru.skipp.autopartstore.model.Role;
import ru.skipp.autopartstore.model.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ru.skipp.autopartstore.repository.UserRepository;

import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class AutoPartStoreApplication implements ApplicationRunner {
	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AutoPartStoreApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		userRepository.save(new User("user@gmail.com", "User_First", "User_Last", "password", Set.of(Role.ROLE_USER)));
		userRepository.save(new User("admin@yandex.ru", "Admin_First", "Admin_Last", "admin", Set.of(Role.ROLE_USER, Role.ROLE_ADMIN)));
		System.out.println(userRepository.findAll());
	}

}
