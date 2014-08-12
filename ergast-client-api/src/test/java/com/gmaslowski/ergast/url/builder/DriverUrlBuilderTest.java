package com.gmaslowski.ergast.url.builder;

import static com.gmaslowski.ergast.url.builder.DriverUrlBuilder.driver;
import static com.gmaslowski.ergast.url.testdata.DriverTestData.ALONSO;
import static org.fest.assertions.Assertions.assertThat;
import com.gmaslowski.ergast.test.AbstractUnitTest;
import org.junit.Test;

public class DriverUrlBuilderTest extends AbstractUnitTest {

    private String path;

    @Test
    public void shouldAppendDriversPathToUrl() {
        // when
        path = driver().path();

        // then
        assertThat(path).contains("/drivers");
    }

    @Test
    public void shouldAppendDriversPathWithGivenDriverToUrl() {
        // when
        path = driver(ALONSO).path();

        // then
        assertThat(path).contains("/drivers/alonso");
    }
}
