package net.skhu.controller;

import net.skhu.dto.RegisterUserDto;
import net.skhu.dto.ResponsemMessageDto;
import net.skhu.service.JoinUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.JoinColumn;
import java.sql.ResultSet;

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

    @GetMapping("password1/{password1}/password2/{password2}")
    public ResponsemMessageDto comfirmIdPW(@PathVariable("password1") String password1,@PathVariable("password2") String password2){
        ResponsemMessageDto responsemMessageDto = new ResponsemMessageDto();

         if(password1.equals(password2))
         {responsemMessageDto.setResult(true);}
         else{
             responsemMessageDto.setResult(false);
         }
    return responsemMessageDto;
    }

    @GetMapping("userid/{userid}/name/{name}/password/{password}/email/{email}/departmentId/{departmentId}")
    public ResponsemMessageDto registerRequest(@PathVariable("userid") String userid,
                                               @PathVariable("name") String name,
                                               @PathVariable("password") String password,
                                               @PathVariable("email") String email,
                                               @PathVariable("departmentId") int departmentId){


       return joinUserService.register(userid,password,name,email,departmentId);

    }



}
