package com.stackroute.newz.test.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.newz.controller.UserProfileController;
import com.stackroute.newz.model.UserProfile;
import com.stackroute.newz.service.UserProfileService;
import com.stackroute.newz.util.exception.UserProfileAlreadyExistsException;
import com.stackroute.newz.util.exception.UserProfileNotExistsException;

@SpringBootTest
class UserProfileControllerTest {


	private MockMvc mockMvc;
	private UserProfile userProfile;
	private List<UserProfile> userProfiles;
	
	@Mock
	UserProfileService userService;
	@InjectMocks
	UserProfileController userController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		userProfiles = new ArrayList<UserProfile>();
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
		userProfile = new UserProfile("johnsmith", "John", "Smith", "1234567890", LocalDateTime.now(), null);
		UserProfile userProfile1 = new UserProfile("chrisadler", "Chris", "Adler", "1234567891", LocalDateTime.now(), null);
		UserProfile userProfile2 = new UserProfile("willdavis", "William", "Davis", "1234567892", LocalDateTime.now(), null);
		userProfiles.add(userProfile1);
		userProfiles.add(userProfile2);
	}
	
	@Test
    public void registerUserSuccess() throws Exception {

        when(userService.registerUser(any())).thenReturn(userProfile);
        mockMvc.perform(post("/api/v1/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userProfile)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());

    }

    @SuppressWarnings("unchecked")
	@Test
    public void registerUserFailure() throws Exception {

        when(userService.registerUser(any())).thenThrow(UserProfileAlreadyExistsException.class);
        mockMvc.perform(post("/api/v1/user")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(userProfile)))
                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());

    }
    
	@Test
    public void getAllUsersSuccess() throws Exception {

        when(userService.getAllUserProfiles()).thenReturn(userProfiles);
        mockMvc.perform(get("/api/v1/user").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
	
    @Test
    public void getByUserIdSuccess() throws Exception {

        when(userService.getUserProfile("johnsmith")).thenReturn(userProfile);
        mockMvc.perform(get("/api/v1/user/johnsmith").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void getByUserIdFailure() throws Exception {

        when(userService.getUserProfile("johnsmith")).thenThrow(UserProfileNotExistsException.class);
        mockMvc.perform(get("/api/v1/user/johnsmith").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }
    
    
    @Test
    public void updateUserSuccess() throws Exception {

        when(userService.updateUserProfile(any(),any())).thenReturn(userProfile);
        mockMvc.perform(put("/api/v1/user/johnsmith")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userProfile)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void updateUserFailure() throws Exception {

        when(userService.updateUserProfile(any(),any())).thenThrow(UserProfileNotExistsException.class);
        mockMvc.perform(put("/api/v1/user/johnsmith")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userProfile)))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print());

    }
    
    
    @Test
    public void deleteUserSuccess() throws Exception {

        mockMvc.perform(delete("/api/v1/user/johnsmith")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }
    
    
	@Test
    public void deleteUserFailure() throws Exception {
    	doThrow(UserProfileNotExistsException.class).doNothing().when(userService).deleteUserProfile(any());
//       when(userService.deleteUserProfile(any())).thenThrow(UserProfileNotExistsException.class);
        mockMvc.perform(delete("/api/v1/user/johnsmith")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
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
