package com.github.ogstation.member.service;

import com.github.ogstation.member.dao.MemberDao;
import com.github.ogstation.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService
{
    @Autowired
    private MemberDao memberDao;

    @Override
    public Member get(String key)
    {
        return memberDao.get(key);
    }

    @Override
    public List<Member> get(Pageable pageable)
    {
        return memberDao.get(pageable);
    }

    @Override
    public Member create(Member member)
    {
        return memberDao.create(member);
    }

    @Override
    public Member update(Member member)
    {
        return memberDao.update(member);
    }

    @Override
    public Member delete(String key)
    {
        return memberDao.delete(key);
    }

    @Override
    public Member search(Member member)
    {
        return memberDao.search(member);
    }
}
