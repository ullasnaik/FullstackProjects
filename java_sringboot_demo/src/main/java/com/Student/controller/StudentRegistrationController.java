package com.Student.controller;

import com.Student.beans.StudentRegistration;
import com.Student.beans.StudentRegistrationReply;
import com.Student.beans.Students;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentRegistrationController {
   @RequestMapping(method = RequestMethod.POST,value = "/student/register")
   @ResponseBody
   public StudentRegistrationReply registerStudent(@RequestBody Students stud){
       StudentRegistrationReply studRReply = new StudentRegistrationReply();
       StudentRegistration.getInstance().add(stud);
       studRReply.setName(stud.getName());
       studRReply.setAge(stud.getAge());
       studRReply.setrNum(stud.getRnum());
       studRReply.setrStatus("Successful");
       return studRReply;



   }
}
