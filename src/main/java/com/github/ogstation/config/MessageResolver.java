package com.github.ogstation.config;

public interface MessageResolver
{
    String getMessage(String code);

    String getMessage(String code, Object[] params);
}
