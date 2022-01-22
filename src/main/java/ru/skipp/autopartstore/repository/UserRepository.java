package ru.skipp.autopartstore.repository;

import ru.skipp.autopartstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
