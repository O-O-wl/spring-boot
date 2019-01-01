package dev.east0.service;

import dev.east0.domain.Student;
import dev.east0.dto.ResponsemMessageDto;
import dev.east0.repository.*;
import org.springframework.stereotype.Service;

@Service
public class AddDataService {
    DepartmentRepository departmentRepository;

    StudentRepository studentRepository;

    UserRepository userRepository;

    RegisterRepository registerRepository;

    ProfessorRepository professorRepository;

    CourseRepository courseRepository;

     TranformService tranformService;

    /*********************************
     * 생성자 === @Controller 에서 @Autowired 되어 인스턴트 생성시 ,
     *          바로 Repository 도 자동생성
     * @param studentRepository
     * @param userRepository
     * @param departmentRepository
     * @param professorRepository
     * @param registerRepository
     * @param courseRepository
     *
     */

    public AddDataService(StudentRepository studentRepository,
                          UserRepository userRepository,
                          DepartmentRepository departmentRepository,
                          ProfessorRepository professorRepository,
                          RegisterRepository registerRepository,
                          CourseRepository courseRepository,
                          TranformService tranformService){

        this.registerRepository=registerRepository;
        this.studentRepository=studentRepository;
        this.userRepository=userRepository;
        this.departmentRepository=departmentRepository;
        this.professorRepository=professorRepository;
        this.courseRepository=courseRepository;
        this.tranformService=tranformService;
    }

    /* **************************************
    *
    *    외부 소스 참고 할 필요있음
    *    더티 구현 소스 리팩토링 필요
    *   !@Service layer 에서 다른 Service 참조 !
    *
    ****************************************** */
    public ResponsemMessageDto addStudent(String studentNo, String studentName, int departmentId, int year){

        ResponsemMessageDto responsemMessageDto = new ResponsemMessageDto();
        Student student = new Student();
        student = tranformService.tranformStudent(0,studentNo,studentName,departmentId,year);
        responsemMessageDto.setResult(studentRepository.save(student)!=null);
        return responsemMessageDto;

    }
}
