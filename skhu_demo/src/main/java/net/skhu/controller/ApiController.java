package net.skhu.controller;

import net.skhu.domain.*;
import net.skhu.dto.ResponsemMessageDto;
import net.skhu.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


     @GetMapping("departments")
    public List<Department> findAll_Departments() {
        return departmentRepository.findAll();
    }

    @GetMapping("department/{departmentId}/students")
    public List<Student> studentListByDepartment(@PathVariable("departmentId")int departmentId){

         return departmentRepository.findById(departmentId).get().getStudents();
    }


    @GetMapping("student/{studentId}/register")
    public List<Register> courseListByStudent(@PathVariable("studentId")int studentId){

         return studentRepository
                 .findById(studentId)
                 .get()
                 .getRegisters();

    }





}
