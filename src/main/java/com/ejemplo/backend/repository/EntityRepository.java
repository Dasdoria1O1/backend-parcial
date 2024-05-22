package main.java.com.ejemplo.backend.repository;

import main.java.com.ejemplo.backend.model.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityRepository extends JpaRepository<Entity, Long> {
}
