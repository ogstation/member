package com.github.ogstation.member.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class IntegralControllerTest
{

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception
    {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new IntegralController()).build();
    }

    @Test
    public void should_be_able_to_add_integral_for_customer() throws Exception
    {
        // then
        this.mockMvc.perform(post("/api/integral"))
                .andExpect(status().isOk());
    }
}
