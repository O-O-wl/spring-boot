package dev.east0.repository;

import dev.east0.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor , Integer> {
List<Professor> findProfessorByDepartmentId(int departmentId);
}
