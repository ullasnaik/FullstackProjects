package com.stackroute.fitnesszone.productservice.controller;

import com.stackroute.fitnesszone.productservice.entity.Program;
import com.stackroute.fitnesszone.productservice.exception.ProgramAlreadyExistsException;
import com.stackroute.fitnesszone.productservice.exception.ProgramNotFoundException;
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

    @GetMapping("/{programCode}")
    public ResponseEntity<?> getProgramByCode(@PathVariable String programCode) throws ProgramNotFoundException {
        return new ResponseEntity<>(programService.getProgramByCode(programCode), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addProgram(@RequestBody Program program) throws ProgramAlreadyExistsException {
        return new ResponseEntity<>(programService.addNewProgram(program), HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<?> updateProgram(@RequestBody Program program) throws ProgramNotFoundException {
        return new ResponseEntity<>(programService.updateExistingProgram(program), HttpStatus.OK);
    }

    @DeleteMapping("/{programCode}")
    public ResponseEntity<?> deleteProgram(@PathVariable String programCode) throws ProgramNotFoundException {
        programService.deleteProgram(programCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/showAllActive")
    public ResponseEntity<?> listAllActivePrograms() {
        return new ResponseEntity<>(programService.listAllActivePrograms(), HttpStatus.OK);
    }

}
