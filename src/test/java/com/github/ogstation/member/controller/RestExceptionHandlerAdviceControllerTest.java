package com.github.ogstation.member.controller;

import com.github.ogstation.member.domain.error.RestErrorResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Arrays;
import java.util.Locale;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RestExceptionHandlerAdviceControllerTest
{
    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private RestExceptionHandlerAdviceController restExceptionHandlerAdviceController;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        when(messageSource.getMessage(any(MessageSourceResolvable.class), any(Locale.class))).thenReturn("error message");
        restExceptionHandlerAdviceController = new RestExceptionHandlerAdviceController(messageSource);

    }

    @Test
    public void should_be_able_to_handle_Method_argument_not_valid_exception() throws Exception
    {
        // given
        MethodArgumentNotValidException methodArgumentNotValidException = mock(MethodArgumentNotValidException.class);
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.getFieldErrors()).thenReturn(Arrays.asList(new FieldError("station", "name", "should not be empty")));
        when(methodArgumentNotValidException.getBindingResult()).thenReturn(bindingResult);

        // when
        RestErrorResponse restErrorResponse = restExceptionHandlerAdviceController.handleBeanValidationError(methodArgumentNotValidException);

        // then
        assertThat(restErrorResponse, notNullValue());
    }

    @Test
    public void should_be_able_to_return_default_message() throws Exception
    {
        // given
        when(messageSource.getMessage(any(MessageSourceResolvable.class), any(Locale.class))).thenReturn("");
        restExceptionHandlerAdviceController = new RestExceptionHandlerAdviceController(messageSource);
        MethodArgumentNotValidException methodArgumentNotValidException = mock(MethodArgumentNotValidException.class);
        BindingResult bindingResult = mock(BindingResult.class);
        FieldError fieldError = mock(FieldError.class);
        when(fieldError.getField()).thenReturn("name");
        when(fieldError.getDefaultMessage()).thenReturn("default message");
        when(fieldError.getCodes()).thenReturn(new String[] {"message"});
        when(bindingResult.getFieldErrors()).thenReturn(Arrays.asList(fieldError));
        when(methodArgumentNotValidException.getBindingResult()).thenReturn(bindingResult);

        // when
        RestErrorResponse restErrorResponse = restExceptionHandlerAdviceController.handleBeanValidationError(methodArgumentNotValidException);

        // then
        assertThat(restErrorResponse, notNullValue());
    }
}