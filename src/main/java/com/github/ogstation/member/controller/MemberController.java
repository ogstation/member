package com.github.ogstation.member.controller;

import com.github.ogstation.member.domain.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("api/member")
public class MemberController
{
    @RequestMapping(value = "search", method = POST)
    public ResponseEntity<Member> search(@RequestBody Member member)
    {
        return new ResponseEntity<Member>(OK);
    }
}
