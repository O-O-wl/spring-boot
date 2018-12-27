package dev.east0.service;

import dev.east0.domain.User;
import dev.east0.dto.ResponsemMessageDto;
import dev.east0.repository.DepartmentRepository;
import dev.east0.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class JoinUserService {

    private UserRepository userRepository;
    private DepartmentRepository departmentRepository;
    public JoinUserService(UserRepository userRepository,DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
        this.userRepository=userRepository;
    }

    //==========================
    // 아이디 중복 여부 확인 api
    //===========================
    public ResponsemMessageDto confirmId(String userid){
        ResponsemMessageDto confirmId = new ResponsemMessageDto();
      if(userRepository.findByUserId(userid).size()<1)
          confirmId.setResult(true);  // 중복안됨 가능
        else {
            confirmId.setResult(false);  //아이디 중복
      }
      return confirmId;
    }

    /* ========================
            가입요청 서비스

         회원가입 성공여부 반환

         !암호화 진행예정
         ! 로직 분리 예정
     ========================== */
    public ResponsemMessageDto register(String userid ,String password ,String name, String email ,int departmentId){
        User user = new User();
        user.setUserId(userid);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        user.setDepartment(departmentRepository.findById(departmentId).get());
        user.setEnabled(true);
        user.setUserType("학생");

        ResponsemMessageDto responsemMessageDto = new ResponsemMessageDto();

        if(confirmId(userid).getResult()){
            userRepository.save(user);
            responsemMessageDto.setResult(true);}
        else{responsemMessageDto.setResult(false);}

        return responsemMessageDto;
    }


}
