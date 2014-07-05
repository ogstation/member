package com.github.ogstation.controller;

import com.github.ogstation.domain.RestError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@RequestMapping("/api/error")
public class GlobalErrorHandlerController
{
    private static final String ERROR_400 = "global.error.400";
    private static final String ERROR_500 = "global.error.500";
    private static final String NOT_FOUND = "400";
    private static final String INTERNAL_ERROR = "500";

    @Autowired
    @Qualifier("errorMessage")
    private Properties errorMessage;

    @RequestMapping("/400")
    public RestError handle400Error()
    {
        return new RestError(NOT_FOUND, errorMessage.getProperty(ERROR_400));
    }

    @RequestMapping("/500")
    public RestError handle500Error()
    {
        return new RestError(INTERNAL_ERROR, errorMessage.getProperty(ERROR_500));
    }
}
