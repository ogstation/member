package com.github.ogstation.member.controller;

import com.github.ogstation.member.domain.Member;
import com.github.ogstation.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("api/member")
public class MemberController
{
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "search", method = POST)
    public ResponseEntity<Member> search(@RequestBody Member member)
    {
        Member result = memberService.search(member);
        if (result == null) {
            return new ResponseEntity<Member>(NOT_FOUND);
        }
        return new ResponseEntity<Member>(result, OK);
    }
}
