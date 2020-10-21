package com.stackroute.fitnesszone.productservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.fitnesszone.productservice.entity.Program;
import com.stackroute.fitnesszone.productservice.exception.ProgramAlreadyExistsException;
import com.stackroute.fitnesszone.productservice.exception.ProgramNotFoundException;
import com.stackroute.fitnesszone.productservice.service.ProgramService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProgramControllerTest {

    private MockMvc mockMvc;
    private Program program;
    private List<Program> programList;


    @Mock
    ProgramService programService;
    @InjectMocks
    ProgramController programController;


    @BeforeEach
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(programController).build();
        programList = new ArrayList<>();
        program = new Program();
        program.setProgramCode("1");
        program.setProgramName("All Access(1 Month)");
        program.setDescription("Access to all equipments with general trainers");
        program.setDurationInMonths(1);
        program.setPrice(1500);
        program.setDiscountRate(10);
        program.setActive(true);
        programList.add(program);

    }

    @Test
    public void getAllProgramsSuccess() throws Exception {

        when(programService.listAllPrograms()).thenReturn(programList);
        mockMvc.perform(get("/api/v1/programservice").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getProgramByCodeSuccess() throws Exception {

        when(programService.getProgramByCode("1")).thenReturn(program);
        mockMvc.perform(get("/api/v1/programservice/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getProgramByCodeFailure() throws Exception {

        when(programService.getProgramByCode("2")).thenReturn(null);
        mockMvc.perform(get("/api/v1/programservice/2").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void addProgramSuccess() throws Exception {

        when(programService.addNewProgram(any())).thenReturn(program);
        mockMvc.perform(post("/api/v1/programservice").contentType(MediaType.APPLICATION_JSON).content(asJsonString(program)))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());

    }


    @Test
    public void addProgramFailure() throws Exception {

        when(programService.addNewProgram(any())).thenThrow(ProgramAlreadyExistsException.class);
        mockMvc.perform(post("/api/v1/programservice").contentType(MediaType.APPLICATION_JSON).content(asJsonString(program)))
                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());

    }


    @Test
    public void updateProgramSuccess() throws Exception {

        when(programService.updateExistingProgram(any())).thenReturn(program);
        mockMvc.perform(put("/api/v1/programservice").contentType(MediaType.APPLICATION_JSON).content(asJsonString(program)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

    }


    @Test
    public void updateProgramFailure() throws Exception {

        when(programService.updateExistingProgram(any())).thenThrow(ProgramNotFoundException.class);
        mockMvc.perform(put("/api/v1/programservice").contentType(MediaType.APPLICATION_JSON).content(asJsonString(program)))
                .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());

    }


    @Test
    public void getAllActiveProgramsSuccess() throws Exception {

        when(programService.listAllActivePrograms()).thenReturn(programList);
        mockMvc.perform(get("/api/v1/programservice/showAllActive").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }




    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

