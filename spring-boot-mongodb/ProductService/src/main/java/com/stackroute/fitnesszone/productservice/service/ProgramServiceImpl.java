package com.stackroute.fitnesszone.productservice.service;

import com.stackroute.fitnesszone.productservice.entity.Program;
import com.stackroute.fitnesszone.productservice.exception.ProgramNotFoundException;
import com.stackroute.fitnesszone.productservice.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {

    private ProgramRepository programRepository;

    @Autowired
    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public Program addNewProgram(Program program) {

        program.calculateDiscountedPrice();
        return programRepository.save(program);
    }

    @Override
    public Program updateExistingProgram(Program program) throws ProgramNotFoundException {
         if(programRepository.findById(program.getProgramCode()).isEmpty()) {
             throw new ProgramNotFoundException();
         }
         program.calculateDiscountedPrice();
        return programRepository.save(program);
    }

    @Override
    public Program getProgramByCode(String programCode) throws ProgramNotFoundException {
        if(programRepository.findById(programCode).isEmpty()) {
            throw new ProgramNotFoundException();
        }
        return programRepository.findById(programCode).get();
    }

    @Override
    public List<Program> listAllPrograms() {
        return programRepository.findAll();
    }

    @Override
    public void deleteProgram(String programCode) throws ProgramNotFoundException {
        if(programRepository.findById(programCode).isEmpty()) {
            throw new ProgramNotFoundException();
        }
        programRepository.deleteById(programCode);
    }
}
