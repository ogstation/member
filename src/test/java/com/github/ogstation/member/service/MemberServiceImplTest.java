package com.github.ogstation.member.service;

import com.github.ogstation.member.dao.MemberDao;
import com.github.ogstation.member.domain.Member;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MemberServiceImplTest
{
    @Mock
    private MemberDao memberDao;

    @InjectMocks
    private MemberServiceImpl memberService;


    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_be_able_to_get_station() throws Exception
    {
        // given
        when(memberDao.get(anyString())).thenReturn(new Member());

        // when
        Member member = memberService.get("key");

        // then
        assertThat(member, notNullValue());
    }

    @Test
    public void should_be_able_to_search_station() throws Exception
    {
        // given
        when(memberDao.search(any(Member.class))).thenReturn(new Member());

        // when
        Member member = memberService.search(new Member());

        // then
        assertThat(member, notNullValue());
    }

    @Test
    public void should_be_able_to_get_stations() throws Exception
    {
        // given
        Pageable pageable = mock(Pageable.class);
        when(memberDao.get(pageable)).thenReturn(Arrays.asList(new Member()));

        // when
        List<Member> members = memberService.get(pageable);

        // then
        assertThat(members.isEmpty(), is(false));
    }

    @Test
    public void should_be_able_to_create() throws Exception
    {
        // given
        Member member = new Member();
        when(memberDao.create(member)).thenReturn(member);

        // when
        Member result = memberService.create(member);

        // then
        assertThat(result, notNullValue());
    }

    @Test
    public void should_be_able_to_update() throws Exception
    {
        // given
        Member member = new Member();
        when(memberDao.update(member)).thenReturn(new Member());

        // when
        Member update = memberService.update(member);

        // then
        assertThat(update, notNullValue());
    }

    @Test
    public void should_be_able_delete() throws Exception
    {
        // given
        when(memberDao.delete(anyString())).thenReturn(new Member());

        // when
        Member member = memberService.delete("key");

        // then
        assertThat(member, notNullValue());
    }
}