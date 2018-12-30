package dev.east0.controller;


import dev.east0.domain.Student;
import dev.east0.domain.User;
import dev.east0.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("api/search")
public class SearchController {

    @Autowired
    SearchService searchService;


    //========================
    //  유저 이름으로 검색
    //  앞부분 일치시 조회
    //========================

    @RequestMapping("userName/{search}")
    public Stream<User> findUserByUserName(@PathVariable("userName") String search){
        return searchService.findUserByUserName(search);
    }

    //=========================
    //  유저 아이디로 검색
    //
    //=========================

    @RequestMapping("userid/{userid}")
    public User findUserByUserId(@PathVariable("userid") String userid){
        return searchService.findUserByUserId(userid);
    }


    //========================
    //  학생 이름으로 검색
    //  앞부분일치 시 조회
    //========================

    @RequestMapping("studentName/{search}")
    public Stream<Student> findByStudentName(@PathVariable("userName") String search){
        return searchService.findByStudentName(search);
    }


}
