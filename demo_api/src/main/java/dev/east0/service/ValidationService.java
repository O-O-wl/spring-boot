package dev.east0.service;

import dev.east0.dto.ResponsemMessageDto;
import dev.east0.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class ValidationService {

    private UserRepository userRepository;

    public ValidationService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public ResponsemMessageDto confirmPassword(String password1, String password2){
        ResponsemMessageDto responsemMessageDto = new ResponsemMessageDto();
        if(password1.equals(password2)){
            responsemMessageDto.setResult(true);
        }
        else {
            responsemMessageDto.setResult(false);
        }

        return responsemMessageDto;
    }
}
