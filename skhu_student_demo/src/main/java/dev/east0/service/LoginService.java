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

    public ResponsemMessageDto loginResult(String userid , String password)
    {
        ResponsemMessageDto responsemMessage = new ResponsemMessageDto();
        System.out.println("----------------------------------");
        System.out.println(userRepository.findByUserId(userid).get(1).getPassword());
        if(userRepository.findByUserId(userid).get(0).getPassword().equals(password)){
            responsemMessage.setResult(true);
        }
        else {
            responsemMessage.setResult(false);
        }

        return  responsemMessage;
    }



}
