package com.github.ogstation.member.controller;

import com.github.ogstation.member.domain.Member;
import com.github.ogstation.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static com.github.ogstation.member.helper.RestURIConstants.CREATE_MEMBER;
import static com.github.ogstation.member.helper.RestURIConstants.DELETE_MEMBER;
import static com.github.ogstation.member.helper.RestURIConstants.GET_ALL_MEMBER;
import static com.github.ogstation.member.helper.RestURIConstants.GET_MEMBER;
import static com.github.ogstation.member.helper.RestURIConstants.SEARCH_MEMBER;
import static com.github.ogstation.member.helper.RestURIConstants.UPDATE_MEMBER;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class MemberController
{
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = SEARCH_MEMBER, method = POST)
    public ResponseEntity<Member> search(@RequestBody Member member)
    {
        Member result = memberService.search(member);
        if (result == null) {
            return new ResponseEntity<Member>(NOT_FOUND);
        }
        return new ResponseEntity<Member>(result, OK);
    }

    @RequestMapping(value = GET_ALL_MEMBER, method = GET)
    public ResponseEntity<List<Member>> getMembersByPageable(@PageableDefault Pageable pageable)
    {
        List<Member> gasStations = memberService.get(pageable);
        return new ResponseEntity<List<Member>>(gasStations, OK);
    }

    @RequestMapping(value = GET_MEMBER, method = GET)
    public ResponseEntity<Member> get(@PathVariable String id)
    {
        Member member = memberService.get(id);
        if (member == null) {
            return new ResponseEntity<Member>(NOT_FOUND);
        }
        return new ResponseEntity<Member>(member, OK);
    }

    @RequestMapping(value = CREATE_MEMBER, method = POST)
    public ResponseEntity<Member> create(@Valid @RequestBody Member member)
    {

        Member created = memberService.create(member);
        if (created == null) {
            return new ResponseEntity<Member>(BAD_REQUEST);
        }
        return new ResponseEntity<Member>(member, OK);
    }

    @RequestMapping(value = UPDATE_MEMBER, method = PUT)
    public ResponseEntity<Member> update(@Valid @RequestBody Member member)
    {
        Member update = memberService.update(member);
        if (update == null) {
            return new ResponseEntity<Member>(BAD_REQUEST);
        }
        return new ResponseEntity<Member>(member, OK);
    }

    @RequestMapping(value = DELETE_MEMBER, method = DELETE)
    public ResponseEntity<Member> delete(@PathVariable String id)
    {
        Member gasStation = memberService.delete(id);
        if (gasStation == null) {
            return new ResponseEntity<Member>(NOT_FOUND);
        }
        return new ResponseEntity<Member>(gasStation, OK);
    }
}
