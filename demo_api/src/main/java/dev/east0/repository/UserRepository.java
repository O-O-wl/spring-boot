package dev.east0.repository;

import dev.east0.domain.Department;
import dev.east0.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByUserId(String userid);
    List<User> findUserByDepartment(Department department);
}
