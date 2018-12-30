package dev.east0.controller;

import dev.east0.domain.*;
import dev.east0.service.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/list")
public class GetListController {



    @Autowired
    GetListService getListServiceService;

    //=========================
    //  전체 학과 목록 조회
    //=========================
    @GetMapping("departments")
    public List<Department> findAllDepartments() {
        return getListServiceService.findAllDepartments() ;
    }

    //================================
    //    학과 아이디를 통한 학생 목록 조회
    //================================
    @GetMapping("department/{departmentId}/students")
    public List<Student> studentListByDepartment(@PathVariable("departmentId")int departmentId){

        return getListServiceService.studentListByDepartment(departmentId);
    }

    //================================
    //    학과 아이디를 통한 유저 목록 조회
    //================================
    @GetMapping("department/{departmentId}/users")
    public Stream<User> findUsersByDepartmentId(@PathVariable("departmentId")int departmentId){

        return getListServiceService.findUsersByDepartment(departmentId);
    }
    //=====================
    //  학과별 교수목록조회
    //=====================
    @GetMapping("department/{departmentId}/professors")
    public List<Professor> professorListByDepartment(@PathVariable("departmentId")int departmentId){

        return getListServiceService.professorListByDepartmentId(departmentId);
    }

    //====================================
    //    교수 아이디로 교수가 맡고있는 과목 조회
    // ====================================
    @GetMapping("professor/{professorId}/courses")
    public Stream<Course> courseListByProfessor(@PathVariable("professorId")int professorId){
        return getListServiceService.courseListByProfessor(professorId);

    }

    //====================================
    //    유저 전체 목록 조회
    // ====================================
    @GetMapping("users")
    public Stream<User> findAllUsers(){
        return getListServiceService.findAllUsers();

    }

    //=============================
    //  학생 아이디로 수강과목 목록조회
    //
    //=============================
    @GetMapping("student/{studentId}/courses")
    public Stream<Course> courseListByStudent(@PathVariable("studentId")int studentId){

        return getListServiceService
                .courseListByStudent(studentId);


    }








}
