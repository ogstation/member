package com.github.ogstation.member.controller;

import com.github.ogstation.member.config.MessageResolver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
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
        this.mockMvc = standaloneSetup(globalErrorHandlerController).build();
    }

    @Test
    public void should_be_able_to_handle_400_error() throws Exception
    {
        // then
        this.mockMvc.perform(post("/api/error/400"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("400")));
    }

    @Test
    public void should_be_able_to_handle_401_error() throws Exception
    {
        // then
        this.mockMvc.perform(post("/api/error/401"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("401")));
    }

    @Test
    public void should_be_able_to_handle_403_error() throws Exception
    {
        // then
        this.mockMvc.perform(post("/api/error/403"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("403")));
    }

    @Test
    public void should_be_able_to_handle_404_error() throws Exception
    {
        // then
        this.mockMvc.perform(post("/api/error/404"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("404")));
    }

    @Test
    public void should_be_able_to_handle_500_error() throws Exception
    {
        // then
        this.mockMvc.perform(get("/api/error/500"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("500")));
    }
}
