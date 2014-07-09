package com.github.ogstation.member.config;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static com.github.ogstation.member.helper.MessageCodes.GLOBAL_ERROR_400;
import static com.github.ogstation.member.helper.MessageCodes.GLOBAL_ERROR_500;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class MessageResolverImplTest
{

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private MessageResolverImpl messageResolver;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void should_be_able_to_get_message() throws Exception
    {
        // given
        when(messageSource.getMessage(GLOBAL_ERROR_400, null, Locale.getDefault())).thenReturn("test");

        // when
        String message = messageResolver.getMessage(GLOBAL_ERROR_400);

        // then
        assertThat(message, is("test"));
    }

    @Test
    public void should_be_able_to_get_message_when_pass_parameters() throws Exception
    {
        // given
        String[] params = {"test", "params"};
        when(messageSource.getMessage(GLOBAL_ERROR_500, params, Locale.getDefault())).thenReturn("test");

        // when
        String message = messageResolver.getMessage(GLOBAL_ERROR_500, params);

        // then
        assertThat(message, is("test"));
    }
}