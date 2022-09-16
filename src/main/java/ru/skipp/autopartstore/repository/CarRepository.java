package ru.skipp.autopartstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.skipp.autopartstore.model.Car;

@Transactional(readOnly = true)
public interface CarRepository extends JpaRepository<Car, Long> {
}
