package com.github.ogstation.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Properties;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class GlobalErrorHandlerControllerTest
{

    @Mock
    private Properties errorMessage;
    private MockMvc mockMvc;

    @InjectMocks
    private GlobalErrorHandlerController globalErrorHandlerController;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        when(errorMessage.getProperty("global.error.400")).thenReturn("api not found");
        this.mockMvc = standaloneSetup(globalErrorHandlerController).build();
    }

    @Test
    public void should_be_able_to_handle_400_error() throws Exception
    {
        // then
        this.mockMvc.perform(post("/api/error/400"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("errorCode").value("400"));
    }

    @Test
    public void should_be_able_to_handle_500_error() throws Exception
    {
        // then
        this.mockMvc.perform(get("/api/error/500"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("errorCode").value("500"));
    }
}
