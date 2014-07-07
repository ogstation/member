package com.github.ogstation.controller;

import com.github.ogstation.config.MessageResolver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.ogstation.helper.MessageCodes.GLOBAL_ERROR_400;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class GlobalErrorHandlerControllerTest
{

    private MockMvc mockMvc;

    @Mock
    private MessageResolver messageResolver;

    @InjectMocks
    private GlobalErrorHandlerController globalErrorHandlerController;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        when(messageResolver.getMessage(GLOBAL_ERROR_400)).thenReturn("api not found");
        this.mockMvc = standaloneSetup(globalErrorHandlerController).build();
    }

    @Test
    public void should_be_able_to_handle_400_error() throws Exception
    {
        // then
        this.mockMvc.perform(post("/api/error/400"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("errorCode", is("400")));
    }

    @Test
    public void should_be_able_to_handle_401_error() throws Exception
    {
        // then
        this.mockMvc.perform(post("/api/error/401"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("errorCode", is("401")));
    }

    @Test
    public void should_be_able_to_handle_403_error() throws Exception
    {
        // then
        this.mockMvc.perform(post("/api/error/403"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("errorCode", is("403")));
    }

    @Test
    public void should_be_able_to_handle_404_error() throws Exception
    {
        // then
        this.mockMvc.perform(post("/api/error/404"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("errorCode", is("404")));
    }

    @Test
    public void should_be_able_to_handle_500_error() throws Exception
    {
        // then
        this.mockMvc.perform(get("/api/error/500"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("errorCode", is("500")));
    }
}
