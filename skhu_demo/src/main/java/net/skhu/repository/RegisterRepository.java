package net.skhu.repository;

import net.skhu.domain.Professor;
import net.skhu.domain.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository  extends JpaRepository<Register,Integer> {
}
