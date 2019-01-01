package dev.east0.controller;

import dev.east0.dto.ResponsemMessageDto;
import dev.east0.service.AddDataService;
import dev.east0.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/add")
public class AddDataController {

    @Autowired
    AddDataService addDataService;
    @Autowired
    ValidationService validationService;

    /* *****************************
    *
    *       로직 분할 필요해보임
    *    적절한 리턴 값인지 확인 필요
    *
    ******************************** */
    @GetMapping("student/studentNo/{studentNo}/studentName/{name}/departmentId/{departmentId}/year/{year}")
    public ResponsemMessageDto addStudent(@PathVariable("studentNo") String studentNo,
                                          @PathVariable("name") String name,
                                          @PathVariable("departmentId") int departmentId,
                                          @PathVariable("year") int year){

        if(validationService.confirmStudentNo(studentNo).getResult()) {
            return addDataService.addStudent(studentNo,name,departmentId,year);


        }
        else{return validationService.confirmStudentNo(studentNo);}
    }

}
