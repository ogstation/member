package com.github.ogstation.member.dao;

import com.github.ogstation.member.domain.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDaoImpl extends BaseDao<Member> implements MemberDao
{
    @Override
    public Member search(Member member)
    {
        return super.search("searchMember", member);
    }

    @Override
    public Member get(String key)
    {
        return super.get("getMemberById", key);
    }

    @Override
    public Member getByName(String name)
    {
        return super.get("getMemberByName", name);
    }

    @Override
    public List<Member> get(Pageable pageable)
    {
        return super.get("getMembersByPageable", pageable);
    }

    @Override
    public Member create(Member member)
    {
        int insertMember = super.create("insertMember", member);
        return get(String.valueOf(insertMember));
    }

    @Override
    public Member update(Member member)
    {
        int updateMember = super.update("updateMember", member);
        return get(String.valueOf(updateMember));
    }

    @Override
    public Member delete(String key)
    {
        int deleteMember = super.delete("deleteMember", key);
        return get(String.valueOf(deleteMember));
    }
}
