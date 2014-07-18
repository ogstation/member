package com.github.ogstation.member.dao;

import com.github.ogstation.member.domain.Member;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mybatis.spring.SqlSessionTemplate;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
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
}