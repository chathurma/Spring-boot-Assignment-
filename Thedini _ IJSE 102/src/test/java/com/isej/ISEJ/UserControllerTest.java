package com.isej.ISEJ;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isej.ISEJ.api.controller.UserController;
import com.isej.ISEJ.api.request.UserRequest;
import com.isej.ISEJ.api.response.UserResponse;
import com.isej.ISEJ.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


    @Test
    void testAddUser() throws Exception {
        // Prepare test data
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("testuser");
        userRequest.setPassword("testpassword");
        userRequest.setEmail("testuser@example.com");
        userRequest.setRole("1005");

        UserResponse mockUserResponse = new UserResponse();
        mockUserResponse.setId(1);
        mockUserResponse.setUsername("testuser");
        mockUserResponse.setEmail("testuser@example.com");
        mockUserResponse.setRole("1005");

        // Mock the service method to return the expected response
        when(userService.addUser(userRequest)).thenReturn(mockUserResponse);

        // Convert the UserRequest to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(userRequest);

        // Build the request
        RequestBuilder requestBuilder = post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson);

        // Perform the request and verify the response
        ResultActions resultActions = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("testuser"))
                .andExpect(jsonPath("$.email").value("testuser@example.com"))
                .andExpect(jsonPath("$.role").value("USER"));

        // Verify that the userService.addUser method was called once with the expected UserRequest
        verify(userService, times(1)).addUser(userRequest);

        // Verify that no more interactions with userService occurred
        verifyNoMoreInteractions(userService);

        // Extract and print the content of the response (useful for debugging)
        MvcResult mvcResult = resultActions.andReturn();
        System.out.println("Response: " + mvcResult.getResponse().getContentAsString());
    }
}
