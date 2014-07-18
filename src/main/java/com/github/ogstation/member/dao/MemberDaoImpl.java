package com.github.ogstation.member.dao;

import com.github.ogstation.member.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl extends BaseDao<Member> implements MemberDao
{
    @Override
    public Member search(Member member)
    {
        return super.search("searchMember", member);
    }
}
