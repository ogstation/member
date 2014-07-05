package com.github.ogstation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageResolverImpl implements MessageResolver
{
    @Autowired
    private MessageSource messageSource;

    @Override
    public String getMessage(String code)
    {
        return messageSource.getMessage(code, null, Locale.getDefault());
    }

    @Override
    public String getMessage(String code, Object[] params)
    {
        return messageSource.getMessage(code, params, Locale.getDefault());
    }
}
