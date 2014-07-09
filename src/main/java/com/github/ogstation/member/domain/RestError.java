package com.github.ogstation.member.domain;

public class RestError
{
    private final String errorCode;
    private final String errorMessage;

    public RestError(String errorCode, String errorMessage)
    {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }
}
