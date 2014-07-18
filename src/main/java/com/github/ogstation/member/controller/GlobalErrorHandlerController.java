package com.github.ogstation.member.controller;

import com.github.ogstation.member.config.MessageResolver;
import com.github.ogstation.member.domain.RestError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.ogstation.member.helper.MessageCodes.GLOBAL_ERROR_400;
import static com.github.ogstation.member.helper.MessageCodes.GLOBAL_ERROR_401;
import static com.github.ogstation.member.helper.MessageCodes.GLOBAL_ERROR_403;
import static com.github.ogstation.member.helper.MessageCodes.GLOBAL_ERROR_404;
import static com.github.ogstation.member.helper.MessageCodes.GLOBAL_ERROR_500;

@RestController
@RequestMapping("/api/error")
public class GlobalErrorHandlerController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalErrorHandlerController.class);
    private static final String BAD_REQUEST = "400";
    private static final String UNAUTHORIZED = "401";
    private static final String FORBIDDEN = "403";
    private static final String NOT_FOUND = "404";
    private static final String INTERNAL_ERROR = "500";

    @Autowired
    private MessageResolver messageResolver;

    @RequestMapping("/400")
    public RestError handle400Error()
    {
        return new RestError(BAD_REQUEST, messageResolver.getMessage(GLOBAL_ERROR_400));
    }

    @RequestMapping("/401")
    public RestError handle401Error()
    {
        return new RestError(UNAUTHORIZED, messageResolver.getMessage(GLOBAL_ERROR_401));
    }

    @RequestMapping("/403")
    public RestError handle403Error()
    {
        return new RestError(FORBIDDEN, messageResolver.getMessage(GLOBAL_ERROR_403));
    }

    @RequestMapping("/404")
    public RestError handle404Error()
    {
        return new RestError(NOT_FOUND, messageResolver.getMessage(GLOBAL_ERROR_404));
    }

    @RequestMapping("/500")
    public RestError handle500Error()
    {
        LOGGER.debug("500 internal error");
        return new RestError(INTERNAL_ERROR, messageResolver.getMessage(GLOBAL_ERROR_500));
    }
}