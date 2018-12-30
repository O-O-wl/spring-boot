package dev.east0.service;


import dev.east0.domain.Student;
import dev.east0.domain.User;
import dev.east0.repository.*;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class SearchService {

    DepartmentRepository departmentRepository;

    StudentRepository studentRepository;

    UserRepository userRepository;

    RegisterRepository registerRepository;

    ProfessorRepository professorRepository;

    CourseRepository courseRepository;

    /*********************************
     * 싱글턴 위배?
     *
     * 생성자 === @Controller 에서 @Autowired 되어 인스턴트 생성시 ,
     *          바로 Repository 도 자동생성
     * @param studentRepository
     * @param userRepository
     * @param departmentRepository
     * @param professorRepository
     * @param registerRepository
     * @param courseRepository
     */

    public SearchService(StudentRepository studentRepository,
                         UserRepository userRepository,
                         DepartmentRepository departmentRepository,
                         ProfessorRepository professorRepository,
                         RegisterRepository registerRepository,
                         CourseRepository courseRepository) {

        this.registerRepository = registerRepository;
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
        this.professorRepository = professorRepository;
        this.courseRepository = courseRepository;
    }


    //=========================
    //  유저 아이디로 검색
    //
    //=========================


    public User findUserByUserId(String userid){

        return userRepository.findByUserId(userid).get(0);
    }


    //===================================
    //  Stream - API
    //  유저 이름 검색 결과 -- 앞부분 일치 검색
    //===================================

    public Stream<User> findUserByUserName(String search){
        return userRepository
                .findByNameStartingWith(search)
                .stream()
                .map(user->user);
    }




    //===================================
    //  Stream - API
    //  학생 이름 검색 결과 -- 앞부분 일치 검색
    //===================================

    public Stream<Student> findByStudentName(String search){
        return studentRepository
                .findByNameStartingWith(search)
                .stream()
                .map(student->student);
    }





}
