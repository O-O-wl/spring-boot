package dev.east0.service;


import dev.east0.dto.ResponsemMessageDto;
import dev.east0.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {




    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }




    /* ===========================
        로그인 시도후 성공여부 반환

          ! 암호화 진행예정
     ============================*/
    public ResponsemMessageDto loginResult(String userid , String password)
    {
        ResponsemMessageDto responseMessage = new ResponsemMessageDto();


        if(userRepository.findByUserId(userid).get(0).getPassword().equals(password)){
            responseMessage.setResult(true);
        }
        else {
            responseMessage.setResult(false);
        }

        return  responseMessage;
    }



}
