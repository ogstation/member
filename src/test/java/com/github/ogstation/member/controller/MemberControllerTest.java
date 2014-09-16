package com.github.ogstation.member.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ogstation.member.domain.Member;
import com.github.ogstation.member.service.MemberService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Arrays;
import java.util.Locale;

import static com.github.ogstation.member.helper.RestURIConstants.SEARCH_MEMBER;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
        this.mockMvc = standaloneSetup(memberController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers(new ViewResolver()
                {
                    @Override
                    public View resolveViewName(String viewName, Locale locale) throws Exception
                    {
                        return new MappingJackson2JsonView();
                    }
                }).build();
    }

    @Test
    public void should_be_able_to_get_member() throws Exception
    {
        // given
        Member member = new Member();
        when(memberService.search(any(Member.class))).thenReturn(member);

        // then
        this.mockMvc.perform(post(SEARCH_MEMBER)
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
        this.mockMvc.perform(post(SEARCH_MEMBER)
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(member)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void should_be_able_to_get_members_by_pagesize() throws Exception
    {
        // when
        when(memberService.get(any(Pageable.class))).thenReturn(Arrays.asList(buildMember()));

        // then
        this.mockMvc.perform(get("/api/members/?page=2&size=50")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].identityCard", is("identityCard")));
    }

    @Test
    public void should_be_able_to_get_station() throws Exception
    {
        // when
        when(memberService.get(anyString())).thenReturn(buildMember());

        // then
        this.mockMvc.perform(get("/api/members/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.identityCard", is("identityCard")));
    }

    @Test
    public void should_be_able_to_create_station() throws Exception
    {
        // when
        when(memberService.create(any(Member.class))).thenReturn(buildMember());

        // then
        this.mockMvc.perform(post("/api/members")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(buildMember())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.identityCard", is("identityCard")));
    }

    @Test
    public void should_raise_error_when_get_station_is_not_exist() throws Exception
    {
        // when
        when(memberService.get(anyString())).thenReturn(null);

        // then
        this.mockMvc.perform(get("/api/members/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void should_be_able_to_update_station() throws Exception
    {
        // when
        when(memberService.update(any(Member.class))).thenReturn(buildMember());

        // then
        this.mockMvc.perform(put("/api/members/1")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(buildMember())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.identityCard", is("identityCard")));
    }

    @Test
    public void should_raise_error_when_update_station_is_not_exist() throws Exception
    {
        // when
        when(memberService.update(any(Member.class))).thenReturn(null);

        // then
        this.mockMvc.perform(put("/api/members/1")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(buildMember())))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void should_be_able_to_delete_station() throws Exception
    {
        // when
        when(memberService.delete(anyString())).thenReturn(buildMember());

        // then
        this.mockMvc.perform(delete("/api/members/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void should_raise_error_when_delete_station_is_not_exist() throws Exception
    {
        // when
        when(memberService.delete(anyString())).thenReturn(null);

        // then
        this.mockMvc.perform(delete("/api/members/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    private Member buildMember()
    {
        Member member = new Member();
        member.setIdentityCard("identityCard");
        member.setAddressDetail("addressDetails");
        member.setAge(29);
        member.setBirthday("1997-02-30");
        member.setCityCode("1231");
        member.setCompany("company");
        member.setCountryCode("countryCode");
        member.setConstellation("constellation");
        member.setEmail("email");
        member.setGender("gender");
        member.setEnglishName("englishName");
        member.setHomepage("homepage");
        member.setNationCode("nationCode");
        member.setNickName("nickName");
        member.setProvinceCode("provinceCode");
        member.setRealName("realName");
        return member;
    }
}
