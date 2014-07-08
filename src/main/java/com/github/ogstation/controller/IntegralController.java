package com.github.ogstation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api")
public class IntegralController
{
    @RequestMapping(value = "/integral", method = POST)
    public ResponseEntity<String> integral()
    {
        return new ResponseEntity<String>(OK);
    }
}
