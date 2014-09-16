package com.github.ogstation.member.dao;

import com.github.ogstation.member.domain.Member;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberDao
{

    Member get(String key);

    Member getByName(String name);

    List<Member> get(Pageable pageable);

    Member create(Member member);

    Member update(Member member);

    Member delete(String key);

    Member search(Member member);
}
