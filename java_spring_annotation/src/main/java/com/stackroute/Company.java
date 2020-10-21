package com.stackroute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Company {
    private Employee employee;
    @Autowired
    private Department department;
    // Constructor Dependiency Injection
   @Autowired
    public Company(Employee employee){
        this.employee = employee;


    }
    public void showEmployeeInfo(){
        employee.showEmployeeInfo();
    }

    // Session DI

//    public void setDepartment(Department department){
//        this.department = department;
//    }
    public void showDepartmentInfo(){
        department.showDepartmentInfo();
    }
}
