package dev.east0.service;

import dev.east0.dto.ResponsemMessageDto;
import dev.east0.repository.StudentRepository;
import dev.east0.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;



//========================
//  중복여부 , 가입폼 등
//  오류 확인 서비스
//========================

@Service
public class ValidationService {

    private UserRepository userRepository;
    private StudentRepository studentRepository;

    public ValidationService(UserRepository userRepository,StudentRepository studentRepository){
        this.userRepository=userRepository;
        this.studentRepository=studentRepository;
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

    public ResponsemMessageDto confirmStudentNo(String studentNo){
        ResponsemMessageDto responsemMessageDto = new ResponsemMessageDto();
        if(studentRepository.findByStudentNo(studentNo).size()!=0){
             responsemMessageDto.setResult(false);
        }
        else{
            responsemMessageDto.setResult(true);
        }
        return responsemMessageDto;
    }




}
