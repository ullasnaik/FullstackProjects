package com.stackroute.fitnesszone.productservice.service;

import com.stackroute.fitnesszone.productservice.entity.Program;
import com.stackroute.fitnesszone.productservice.exception.ProgramAlreadyExistsException;
import com.stackroute.fitnesszone.productservice.exception.ProgramNotFoundException;

import java.util.List;

public interface ProgramService {

    Program addNewProgram(Program program) throws ProgramAlreadyExistsException;

    Program updateExistingProgram(Program program) throws ProgramNotFoundException;

    Program getProgramByCode(String programCode) throws ProgramNotFoundException;

    List<Program> getProgramByDuration(int durationInMonths);

    List<Program> listAllPrograms();

    List<Program> listAllActivePrograms();

    void deleteProgram(String programCode) throws ProgramNotFoundException;

}
