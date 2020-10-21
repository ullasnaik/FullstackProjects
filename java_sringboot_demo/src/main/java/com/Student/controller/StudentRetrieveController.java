package com.Student.controller;

import com.Student.beans.StudentRegistration;
import com.Student.beans.Students;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentRetrieveController {
    @RequestMapping(method = RequestMethod.GET,value = "/student/allStudent")
    @ResponseBody
    public List<Students> getAllStudents(){
        return StudentRegistration.getInstance().getStudentRecord();
    }
}
