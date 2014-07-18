package com.github.ogstation.member.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ogstation.member.domain.Member;
import com.github.ogstation.member.service.MemberService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class MemberControllerTest
{
    private MockMvc mockMvc;

    @Mock
    private MemberService memberService;

    @InjectMocks
    private MemberController memberController;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup(memberController).build();
    }

    @Test
    public void should_be_able_to_get_member() throws Exception
    {
        // given
        Member member = new Member();
        when(memberService.search(any(Member.class))).thenReturn(member);

        // then
        this.mockMvc.perform(post("/api/member/search")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(member)))
                .andExpect(status().isOk());
    }

    @Test
    public void should_be_able_to_raise_error() throws Exception
    {
        // given
        Member member = new Member();
        when(memberService.search(any(Member.class))).thenReturn(null);

        // then
        this.mockMvc.perform(post("/api/member/search")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(member)))
                .andExpect(status().isNotFound());
    }
}
