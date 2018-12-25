package net.skhu.controller;

import net.skhu.dto.ResponsemMessageDto;
import net.skhu.service.JoinUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.JoinColumn;

@RestController
@RequestMapping("api/join")
public class JoinUserController {
    @Autowired
    JoinUserService joinUserService;

    // 중복체크

    @GetMapping("id/{userid}")
    public ResponsemMessageDto comfirmId(@PathVariable("userid") String userid){
        return joinUserService.confirmId(userid);
    }


}
