package net.skhu.controller;

import net.skhu.domain.*;
import net.skhu.dto.ResponsemMessageDto;
import net.skhu.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /*
    * 서비스 로직 분리 필요
    * */


    // 학과목록 조회
     @GetMapping("departments")
    public List<Department> findAll_Departments() {
        return departmentRepository.findAll();
    }


    // 학과별 학생조회
    @GetMapping("department/{departmentId}/students")
    public List<Student> studentListByDepartment(@PathVariable("departmentId")int departmentId){

         return departmentRepository.findById(departmentId).get().getStudents();
    }

    // 교수 아이디로 교수가 맡고있는 과목 조회
    @GetMapping("professor/{professorId}/courses")
    public Stream<Course> courseListByProfessor(@PathVariable("professorId")int professorId){
         return professorRepository
                 .findById(professorId)
                 .get()
                 .getCourses()
                 .stream()
                 .map(course -> course);
    }



    //학생 아이디로 수강수조회
    @GetMapping("student/{studentId}/courses")
    public Stream<Course> courseListByStudent(@PathVariable("studentId")int studentId){

         return studentRepository
                 .findById(studentId)
                 .get()
                 .getRegisters()
                 .stream()
                 .map(register->register.getCourse());


    }





}
