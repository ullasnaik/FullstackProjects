package com.stackroute.fitnesszone.productservice.controller;

import com.stackroute.fitnesszone.productservice.entity.Program;
import com.stackroute.fitnesszone.productservice.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/programservice")
public class ProgramController {

    private ProgramService programService;

    @Autowired
    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping
    public ResponseEntity<?> listAllPrograms() {
        return new ResponseEntity<>(programService.listAllPrograms(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addProgram(@RequestBody Program program) {
        return new ResponseEntity<>(programService.addNewProgram(program), HttpStatus.CREATED);
    }


}
