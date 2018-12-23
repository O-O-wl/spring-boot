package net.skhu.controller;

import net.skhu.domain.*;
import net.skhu.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("api")
public class ApiController {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RegisterRepository registerRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    CourseRepository courseRepository;


     @RequestMapping("departments")
    public List<Department> findAll_Departments() {
        return departmentRepository.findAll();
    }

    @RequestMapping("department/{departmentId}/students")
    public List<Student> studentListByDepartment(@PathVariable("departmentId")int departmentId){

         return departmentRepository.findById(departmentId).get().getStudents();
    }

    @RequestMapping("student/{studentId}/register")
    public List<Register> courseListByStudent(@PathVariable("studentId")int studentId){

         return studentRepository
                 .findById(studentId)
                 .get()
                 .getRegisters();

    }



}
