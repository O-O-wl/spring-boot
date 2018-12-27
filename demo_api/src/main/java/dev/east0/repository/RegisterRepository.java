package dev.east0.repository;

import dev.east0.domain.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository  extends JpaRepository<Register,Integer> {
}
