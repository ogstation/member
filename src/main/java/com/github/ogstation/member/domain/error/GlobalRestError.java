package com.github.ogstation.member.domain.error;

public class GlobalRestError
{
    private final String status;
    private final String message;

    public GlobalRestError(String status, String message)
    {
        this.status = status;
        this.message = message;
    }

    public String getStatus()
    {
        return status;
    }

    public String getMessage()
    {
        return message;
    }
}
