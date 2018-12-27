package dev.east0.controller;

import dev.east0.dto.ResponsemMessageDto;
import dev.east0.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/login")
public class LoginController {


    @Autowired
    LoginService loginService;


    /* ==============================
    //      로그인 성공여부 조회
    //
    //  ! @PostMapping 으로 변경 예정
    //================================ */
    @GetMapping("id/{userid}/password/{password}")
    public ResponsemMessageDto loginValidation(@PathVariable("userid")String userid , @PathVariable("password") String password){

        return loginService.loginResult(userid,password);

    }
}
