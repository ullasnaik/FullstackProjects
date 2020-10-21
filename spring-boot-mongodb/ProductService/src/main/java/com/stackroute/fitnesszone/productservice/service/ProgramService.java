package com.stackroute.fitnesszone.productservice.service;

import com.stackroute.fitnesszone.productservice.entity.Program;
import com.stackroute.fitnesszone.productservice.exception.ProgramNotFoundException;

import java.util.List;

public interface ProgramService {

    Program addNewProgram(Program program);

    Program updateExistingProgram(Program program) throws ProgramNotFoundException;

    Program getProgramByCode(String programCode) throws ProgramNotFoundException;

    List<Program> listAllPrograms();

    void deleteProgram(String programCode) throws ProgramNotFoundException;

}
