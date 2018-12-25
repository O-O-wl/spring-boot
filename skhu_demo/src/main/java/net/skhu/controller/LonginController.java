package net.skhu.controller;

import net.skhu.dto.ResponsemMessageDto;
import net.skhu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.AssociationOverride;


@RestController
@RequestMapping("login")
public class LonginController {


    @Autowired
    LoginService loginService;


    // 로그인 확인용 api
    @GetMapping("id/{userid}/pw/{password}")
    public ResponsemMessageDto loginValidation(@PathVariable("userid")String userid , @PathVariable("password") String password){

        return loginService.loginResult(userid,password);

    }
}
