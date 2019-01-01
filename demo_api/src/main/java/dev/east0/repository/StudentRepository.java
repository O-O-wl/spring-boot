package dev.east0.repository;

import dev.east0.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    public List<Student> findByNameStartingWith(String search);
    public List<Student> findByStudentNo(String studentNo);
}
