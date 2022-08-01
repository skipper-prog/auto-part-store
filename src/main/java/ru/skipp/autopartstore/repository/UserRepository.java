package ru.skipp.autopartstore.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.skipp.autopartstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @RestResource(rel = "by-email", path = "by-email")
    @Query("SELECT u FROM User u WHERE u.email = LOWER(:email)")
    Optional<User> findByEmailIgnoreCase(String email);

    @RestResource(rel = "by-lastname", path = "by-lastname")
    List<User> findByLastNameContainingIgnoreCase(String lastName);

    @Override
    @RestResource (exported = false)
    void delete(User user);

    @Override
    @RestResource (exported = false)
    void deleteById(Integer integer);
}
