package com.github.ogstation.member.service;

import com.github.ogstation.member.domain.Member;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberService
{
    Member search(Member member);

    List<Member> get(Pageable pageable);

    Member get(String id);

    Member create(Member member);

    Member update(Member member);

    Member delete(String id);
}
