package net.skhu.controller;

import net.skhu.domain.Department;
import net.skhu.domain.Student;
import net.skhu.repository.DepartmentRepository;
import net.skhu.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    StudentRepository studentRepository;

     @RequestMapping("departments")
    public List<Department> findAll_Departments(Model model){
        return departmentRepository.findAll();
    }
}
