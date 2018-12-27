package dev.east0.controller;

import dev.east0.dto.ResponsemMessageDto;
import dev.east0.service.JoinUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/join")
public class JoinUserController {
    @Autowired
    JoinUserService joinUserService;


    // ====================
    //    학생 아이디 중복체크
    //======================
    @GetMapping("id/{userid}")
    public ResponsemMessageDto comfirmId(@PathVariable("userid") String userid){
        return joinUserService.confirmId(userid);
    }

    /* *****************************
     *  비밀번호 , 비밀번호 확인여부 확인
     *
     *  ! @Service 계층으로 내릴 예정
     *  ! @PostMapping 으로 변경예정
     *  !     암호화 진행예정
     *
    ******************************** */
    @GetMapping("password1/{password1}/password2/{password2}")
    public ResponsemMessageDto comfirmIdPW(@PathVariable("password1") String password1,@PathVariable("password2") String password2){

         ResponsemMessageDto responsemMessageDto = new ResponsemMessageDto();

         if(password1.equals(password2)) {responsemMessageDto.setResult(true); }
         else{responsemMessageDto.setResult(false); }

         return responsemMessageDto;
    }

    /* *****************************************
     *           회원 가입 액션메소드
     *
     *    !  @PostMapping 변경예정
     *    !  회원 수정 로직도 같은 메소드로 구현할 예정
     ********************************************* */
    @GetMapping("userid/{userid}/name/{name}/password/{password}/email/{email}/departmentId/{departmentId}")
    public ResponsemMessageDto registerRequest(@PathVariable("userid") String userid,
                                               @PathVariable("name") String name,
                                               @PathVariable("password") String password,
                                               @PathVariable("email") String email,
                                               @PathVariable("departmentId") int departmentId){

       return joinUserService.register(userid,password,name,email,departmentId);

    }



}
