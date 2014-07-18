package com.github.ogstation.member.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ogstation.member.domain.Member;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class MemberControllerTest
{
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception
    {
        this.mockMvc = standaloneSetup(new MemberController()).build();
    }

    @Test
    public void should_be_able_to_get_member() throws Exception
    {
        // given
        Member member = new Member();

        // then
        this.mockMvc.perform(post("/api/member/search")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(member)))
                .andExpect(status().isOk());
    }
}
