package dev.east0.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api-test")
public class ApiTestController {

    @RequestMapping("index")
    public String api_test(){
        return "Api.jsp";
    }
}
