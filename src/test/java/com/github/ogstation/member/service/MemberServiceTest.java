package com.github.ogstation.member.service;

import com.github.ogstation.member.dao.MemberDao;
import com.github.ogstation.member.domain.Member;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class MemberServiceTest
{
    @Mock
    private MemberDao memberDao;
    @InjectMocks
    private MemberService memberService;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_be_able_to_search_member() throws Exception
    {
        // given
        Member member = new Member();
        when(memberDao.search(member)).thenReturn(member);

        // when
        Member search = memberService.search(member);

        // then
        assertThat(search, notNullValue());
    }
}