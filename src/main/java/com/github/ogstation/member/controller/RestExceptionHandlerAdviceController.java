package com.github.ogstation.member.controller;

import com.github.ogstation.member.domain.error.RestError;
import com.github.ogstation.member.domain.error.RestErrorResponse;
import com.google.common.base.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Locale;

import static com.google.common.collect.FluentIterable.from;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.util.StringUtils.isEmpty;

@ControllerAdvice
public class RestExceptionHandlerAdviceController
{
    private MessageSource messageSource;

    @Autowired
    public RestExceptionHandlerAdviceController(MessageSource messageSource)
    {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public RestErrorResponse handleBeanValidationError(MethodArgumentNotValidException methodArgumentNotValidException)
    {
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        return parseErrors(fieldErrors);
    }

    private RestErrorResponse parseErrors(List<FieldError> fieldErrors)
    {
        List<RestError> restErrors = from(fieldErrors).transform(toRestError()).toList();
        return new RestErrorResponse(restErrors);
    }

    private Function<FieldError, RestError> toRestError()
    {
        return new Function<FieldError, RestError>()
        {
            @Override
            public RestError apply(FieldError fieldError)
            {
                return new RestError(fieldError.getField(), resolveLocalizedErrorMessage(fieldError));
            }
        };
    }

    private String resolveLocalizedErrorMessage(FieldError fieldError)
    {
        Locale currentLocale = LocaleContextHolder.getLocale();
        String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);
        if (isEmpty(localizedErrorMessage)) {
            String[] fieldErrorCodes = fieldError.getCodes();
            return fieldErrorCodes[0];
        }
        return localizedErrorMessage;
    }
}
