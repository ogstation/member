package com.github.ogstation.member.domain.error;

public class RestError
{
    private final String field;
    private final String message;


    public RestError(String field, String message)
    {
        this.field = field;
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public String getField()
    {
        return field;
    }

}
