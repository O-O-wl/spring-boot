package net.skhu.service;


import net.skhu.dto.ResponsemMessageDto;
import net.skhu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
