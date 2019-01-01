package dev.east0.service;

import dev.east0.domain.Student;
import dev.east0.domain.User;
import dev.east0.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class TranformService {

    private DepartmentRepository departmentRepository;

    public TranformService(DepartmentRepository departmentRepository){
        this.departmentRepository=departmentRepository;
    }

    //==========================
    //   입력된 Student데이터
    //  도메인 형태로
    //  Mapping 하는 메소드
    //=========================
    public Student tranformStudent(int id,String studentNo,String studentName,int departmentId,int year){
            Student student =new Student();
            student.setId(id);
            student.setStudentNo(studentNo);
            student.setName(studentName);
            student.setYear(year);
            student.setDepartment(departmentRepository.findById(departmentId).get());
            return student;

    }
    //==========================
    //      입력된 User데이터
    //      도메인 형태로
    //  Mapping 하는 메소드
    //=========================
    public User tranformUser(String userid,String password,String name,String email,int departmentId){
        User user = new User();
        user.setUserId(userid);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        user.setDepartment(departmentRepository.findById(departmentId).get());
        user.setEnabled(true);
        user.setUserType("학생");
        return user;

    }

}
