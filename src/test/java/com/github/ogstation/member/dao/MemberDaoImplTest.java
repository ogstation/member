package com.github.ogstation.member.dao;

import com.github.ogstation.member.domain.Member;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mybatis.spring.SqlSessionTemplate;
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

public class MemberDaoImplTest
{
    @Mock
    private SqlSessionTemplate sqlSessionTemplate;

    @InjectMocks
    private MemberDaoImpl memberDao;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        memberDao.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Test
    public void should_be_able_to_search() throws Exception
    {
        // when
        when(sqlSessionTemplate.selectOne(anyString(), any(Member.class))).thenReturn(new Member());
        Member member = memberDao.search(new Member());

        // then
        assertThat(member, notNullValue());
    }

    @Test
    public void should_be_able_to_get_station() throws Exception
    {
        // when
        when(sqlSessionTemplate.selectOne(anyString(), anyString())).thenReturn(new Member());
        Member member = memberDao.get("key");

        // then
        assertThat(member, notNullValue());
    }

    @Test
    public void should_be_able_to_get_stations_by_pageable() throws Exception
    {
        // given
        Pageable pageable = mock(Pageable.class);

        // when
        when(sqlSessionTemplate.selectList(anyString(), any(Pageable.class))).thenReturn(Arrays.<Object>asList(new Member()));
        List<Member> members = memberDao.get(pageable);

        // then
        assertThat(members.isEmpty(), is(false));
    }

    @Test
    public void should_be_able_to_create_station() throws Exception
    {
        // when
        when(sqlSessionTemplate.insert(anyString(), any(Member.class))).thenReturn(1);
        when(sqlSessionTemplate.selectOne(anyString(), anyString())).thenReturn(new Member());
        Member member = memberDao.create(new Member());

        // then
        assertThat(member, notNullValue());
    }

    @Test
    public void should_be_able_to_update_station() throws Exception
    {
        // when
        when(sqlSessionTemplate.update(anyString(), any(Member.class))).thenReturn(1);
        when(sqlSessionTemplate.selectOne(anyString(), anyString())).thenReturn(new Member());
        Member member = memberDao.update(new Member());

        // then
        assertThat(member, notNullValue());
    }

    @Test
    public void should_be_able_to_delete_station() throws Exception
    {
        // when
        when(sqlSessionTemplate.delete(anyString(), anyString())).thenReturn(1);
        when(sqlSessionTemplate.selectOne(anyString(), anyString())).thenReturn(new Member());
        Member member = memberDao.delete("key");

        // then
        assertThat(member, notNullValue());
    }
}