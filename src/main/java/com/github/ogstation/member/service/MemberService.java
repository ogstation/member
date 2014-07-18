package com.github.ogstation.member.service;

import com.github.ogstation.member.dao.MemberDao;
import com.github.ogstation.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService
{
    @Autowired
    private MemberDao memberDao;

    public Member search(Member member)
    {
        return memberDao.search(member);
    }
}
