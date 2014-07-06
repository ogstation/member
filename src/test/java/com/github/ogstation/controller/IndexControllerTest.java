package com.github.ogstation.controller;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IndexControllerTest
{
    @Test
    public void should_be_able_to_get_index_page() throws Exception
    {
        // when
        IndexController indexController = new IndexController();
        ResponseEntity<String> responseEntity = indexController.index();

        // then
        assertThat(responseEntity.getBody(), is("index page"));
    }
}