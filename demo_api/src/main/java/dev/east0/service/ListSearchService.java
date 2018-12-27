package dev.east0.service;


import dev.east0.domain.*;
import dev.east0.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class ListSearchService {

    DepartmentRepository departmentRepository;

    StudentRepository studentRepository;

    UserRepository userRepository;

    RegisterRepository registerRepository;

    ProfessorRepository professorRepository;

    CourseRepository courseRepository;
    public ListSearchService(StudentRepository studentRepository,
                             DepartmentRepository departmentRepository,
                             ProfessorRepository professorRepository,
                             RegisterRepository registerRepository,
                             CourseRepository courseRepository){
        this.registerRepository=registerRepository;
        this.studentRepository=studentRepository;
        this.departmentRepository=departmentRepository;
         this.professorRepository=professorRepository;
         this.courseRepository=courseRepository;
    }
   public List<Department> findAll_Departments() {
        return departmentRepository.findAll();
    }


    // 학과별 학생조회
    public List<Student> studentListByDepartment(int departmentId){

        return departmentRepository.findById(departmentId).get().getStudents();
    }

    // 교수 아이디로 교수가 맡고있는 과목 조회
    public Stream<Course> courseListByProfessor(int professorId){
        return professorRepository
                .findById(professorId)
                .get()
                .getCourses()
                .stream()
                .map(course -> course);
    }
    public List<Professor> professorListByDepartmentId(int departmentId){

        return professorRepository.findProfessorByDepartmentId(departmentId);
    }


    //학생 아이디로 수강수조회

    public Stream<Course> courseListByStudent(int studentId){

        return studentRepository
                .findById(studentId)
                .get()
                .getRegisters()
                .stream()
                .map(register->register.getCourse());


    }



}
