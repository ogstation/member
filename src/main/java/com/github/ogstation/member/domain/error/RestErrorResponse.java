package com.github.ogstation.member.domain.error;

import java.util.List;

public class RestErrorResponse
{
    private List<RestError> fieldErrors;

    public RestErrorResponse(List<RestError> fieldErrors)
    {
        this.fieldErrors = fieldErrors;
    }

    public void add(String path, String message)
    {
        this.fieldErrors.add(new RestError(path, message));
    }

    public List<RestError> getFieldErrors()
    {
        return fieldErrors;
    }


}
