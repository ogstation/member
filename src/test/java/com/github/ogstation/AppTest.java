package com.github.ogstation;

import com.github.ogstation.App;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AppTest
{
    @Test
    public void should_be_able_to_run_junit_test() throws Exception
    {
        // given
        App app = new App();

        // when
        app.setJunit(true);

        // then
        assertThat(app.isJunit(), is(true));
    }
}
