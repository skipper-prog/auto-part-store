package ru.skipp.autopartstore.repository;

import org.springframework.data.jpa.repository.Query;
import ru.skipp.autopartstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.email = LOWER(:email)")
    Optional<User> findEmailIgnoreCase(String email);

    List<User> findByLastNameContainingIgnoreCase(String lastName);
}
