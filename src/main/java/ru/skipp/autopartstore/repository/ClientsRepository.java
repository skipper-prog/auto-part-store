package ru.skipp.autopartstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skipp.autopartstore.model.Client;

public interface ClientsRepository extends JpaRepository<Client, Long> {
}
