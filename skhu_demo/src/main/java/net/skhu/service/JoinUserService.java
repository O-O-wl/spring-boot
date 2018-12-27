package net.skhu.service;

import net.skhu.domain.User;
import net.skhu.dto.ResponsemMessageDto;
import net.skhu.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.JoinColumn;

@Service
public class JoinUserService {

    private UserRepository userRepository;

    public JoinUserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    // 아이디 중복 여부 확인 api
    public ResponsemMessageDto confirmId(String userid){
        ResponsemMessageDto confirmId = new ResponsemMessageDto();
      if(userRepository.findByUserId(userid).size()<1)
          confirmId.setResult(true);  // 중복안됨 가능
        else {
            confirmId.setResult(false);  //아이디 중복
      }
      return confirmId;
    }

    // 가입요청 서비스
    public ResponsemMessageDto register(String userid ,String password ,String name, String email ,int departmentId){
        User user = new User();
        user.setUserId(userid);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        user.setDepartmentId(departmentId);
        user.setEnabled(true);
        user.setUserType("학생");
        userRepository.save(user);
        ResponsemMessageDto responsemMessageDto = new ResponsemMessageDto();
        responsemMessageDto.setResult(true);
        return responsemMessageDto;
    }


}
