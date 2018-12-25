package net.skhu.repository;

import net.skhu.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor , Integer> {
List<Professor> findProfessorByDepartmentId(int departmentId);
}
