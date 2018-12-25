package net.skhu.controller;

import net.skhu.domain.*;
import net.skhu.dto.ResponsemMessageDto;
import net.skhu.repository.*;
import net.skhu.service.ListSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/list")
public class ListSearchController {


    /*
    * 서비스 로직 분리 필요
    * */

    @Autowired
    ListSearchService listSearchService;

    // 학과목록 조회
    @GetMapping("departments")
    public List<Department> findAll_Departments() {
        return listSearchService.findAll_Departments() ;
    }


    // 학과별 학생조회
    @GetMapping("department/{departmentId}/students")
    public List<Student> studentListByDepartment(@PathVariable("departmentId")int departmentId){

        return listSearchService.studentListByDepartment(departmentId);
    }

    // 교수 아이디로 교수가 맡고있는 과목 조회
    @GetMapping("professor/{professorId}/courses")
    public Stream<Course> courseListByProfessor(@PathVariable("professorId")int professorId){
        return listSearchService.courseListByProfessor(professorId);

    }



    //학생 아이디로 수강수조회
    @GetMapping("student/{studentId}/courses")
    public Stream<Course> courseListByStudent(@PathVariable("studentId")int studentId){

        return listSearchService
                .courseListByStudent(studentId);


    }





}
