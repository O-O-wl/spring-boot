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
    private TranformService tranformService;
    public JoinUserService(TranformService tranformService,UserRepository userRepository,DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
        this.userRepository=userRepository;
        this.tranformService=tranformService;
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

    *
    *    외부 소스 참고 할 필요있음
    *    더티 구현 소스 리팩토링 필요
    *   !@Service layer 에서 다른 Service 참조 !
    *
    *
     ========================== */
    public ResponsemMessageDto register(String userid ,String password ,String name, String email ,int departmentId){

        ResponsemMessageDto responsemMessageDto = new ResponsemMessageDto();

        if(confirmId(userid).getResult()){
            userRepository.save(
                    tranformService.tranformUser(userid,password,name,email,departmentId));
            responsemMessageDto.setResult(true);}
        else{responsemMessageDto.setResult(false);}

        return responsemMessageDto;
    }


}
