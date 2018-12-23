package net.skhu.repository;

import net.skhu.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ProfessorRepository extends JpaRepository<Professor , Integer> {
}
