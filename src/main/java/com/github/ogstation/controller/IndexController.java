package com.github.ogstation.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController
{
    @RequestMapping("/")
    public ResponseEntity<String> index()
    {
        return new ResponseEntity<String>("index page", HttpStatus.ACCEPTED);
    }
}
