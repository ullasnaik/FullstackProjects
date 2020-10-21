package com.Student.beans;

import java.util.ArrayList;
import java.util.List;

public class StudentRegistration {
    private List<Students> studentRecord;
    private static StudentRegistration stdreg = null;
    private StudentRegistration(){
        studentRecord = new ArrayList<Students>();
    }
    public static StudentRegistration getInstance(){
        if(stdreg == null){
            stdreg = new StudentRegistration();
            return stdreg;
        }
        else{
            return stdreg;
        }
    }
    public void add(Students std){
        studentRecord.add(std);
    }
    public List<Students> getStudentRecord(){
        return studentRecord;
    }
}
