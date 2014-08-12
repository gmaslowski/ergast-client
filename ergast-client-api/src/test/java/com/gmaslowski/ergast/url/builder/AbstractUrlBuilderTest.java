package com.gmaslowski.ergast.url.builder;

import static org.fest.assertions.Assertions.assertThat;
import com.gmaslowski.ergast.test.AbstractUnitTest;
import org.junit.Test;

public abstract class AbstractUrlBuilderTest extends AbstractUnitTest {

    abstract String givenPath();
    abstract String expectedPath();

    abstract String givenPathWithValue();
    abstract String expectedPathWithValue();


    @Test
    public void shouldAppendGivenPathToUrl() {
        // then
        assertThat(givenPath()).contains(expectedPath());
    }

    @Test
    public void shouldAppendGivenPathWithGivenValueToUrl() {
        // then
        assertThat(givenPathWithValue()).contains(expectedPathWithValue());
    }
}
