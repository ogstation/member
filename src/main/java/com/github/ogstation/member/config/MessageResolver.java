package com.github.ogstation.member.config;

public interface MessageResolver
{
    String getMessage(String code);

    String getMessage(String code, Object[] params);
}
