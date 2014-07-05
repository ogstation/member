package com.github.ogstation.controller;

import com.github.ogstation.config.MessageResolver;
import com.github.ogstation.domain.RestError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.ogstation.helper.MessageCodes.GLOBAL_ERROR_400;
import static com.github.ogstation.helper.MessageCodes.GLOBAL_ERROR_500;

@RestController
@RequestMapping("/api/error")
public class GlobalErrorHandlerController
{
    private static final String NOT_FOUND = "400";
    private static final String INTERNAL_ERROR = "500";

    @Autowired
    private MessageResolver messageResolver;

    @RequestMapping("/400")
    public RestError handle400Error()
    {
        return new RestError(NOT_FOUND, messageResolver.getMessage(GLOBAL_ERROR_400));
    }

    @RequestMapping("/500")
    public RestError handle500Error()
    {
        return new RestError(INTERNAL_ERROR, messageResolver.getMessage(GLOBAL_ERROR_500));
    }
}
