package dev.east0.service;


import dev.east0.domain.*;
import dev.east0.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;



/* =================================================
    ?
    학과 , 학생 , 교과목등 리스트 출력을 전담하는 서비스클래스
 ==================================================*/

@Service
public class ListSearchService {

    DepartmentRepository departmentRepository;

    StudentRepository studentRepository;

    UserRepository userRepository;

    RegisterRepository registerRepository;

    ProfessorRepository professorRepository;

    CourseRepository courseRepository;

    /*********************************
     * 생성자 === @Controller 에서 @Autowired 되어 인스턴트 생성시 ,
     *          바로 Repository 도 자동생성
     * @param studentRepository
     * @param userRepository
     * @param departmentRepository
     * @param professorRepository
     * @param registerRepository
     * @param courseRepository
     */

    public ListSearchService(StudentRepository studentRepository,
                             UserRepository userRepository,
                             DepartmentRepository departmentRepository,
                             ProfessorRepository professorRepository,
                             RegisterRepository registerRepository,
                             CourseRepository courseRepository){

        this.registerRepository=registerRepository;
        this.studentRepository=studentRepository;
        this.userRepository=userRepository;
        this.departmentRepository=departmentRepository;
         this.professorRepository=professorRepository;
         this.courseRepository=courseRepository;
    }

    //=======================
    //  전체학과목록출력 서비스
    //======================
     public List<Department> findAll_Departments() {
        return departmentRepository.findAll();
    }

    //=================
    //  학과별 학생조회
    //=================
    public List<Student> studentListByDepartment(int departmentId){

        return departmentRepository.findById(departmentId).get().getStudents();
    }

    //====================
    // 유저 전체목록 조회
    //====================
    public Stream<User> findAllUsers(){

        return userRepository
                .findAll()
                .stream()
                .map(user->user);
    }



    //================================
    // 교수 아이디로 교수가 맡고있는 과목 조회
    //
    //  @ 확장위해서 Stream API 로 구현
    //=================================
    public Stream<Course> courseListByProfessor(int professorId){
        return professorRepository
                .findById(professorId)
                .get()
                .getCourses()
                .stream()
                .map(course -> course);
    }
    //=======================================
    //  학과 ID 코드로 전체 소속교수 목록 조회
    //=======================================

    public List<Professor> professorListByDepartmentId(int departmentId){

        return professorRepository.findProfessorByDepartmentId(departmentId);
    }

    //===================================
    //      학생 아이디로 수강과목 목록조회
    //
    //      @ 확장위해서 Stream API 로 구현
    //===================================
    public Stream<Course> courseListByStudent(int studentId){

        return studentRepository
                .findById(studentId)
                .get()
                .getRegisters()
                .stream()
                .map(register->register.getCourse());


    }



}
