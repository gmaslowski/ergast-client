package com.gmaslowski.ergast.url;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.gmaslowski.ergast.url.ErgastUrlBuilder.ergastUrl;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.rules.ExpectedException.none;

public class YearUrlBuilderTest {

    @Rule
    public ExpectedException expectedException = none();

    @Test
    public void shouldCreateDriverInYearUrl() {

        // when
        String url = ergastUrl().year(2013).drivers("alonso").url();

        // then
        assertThat(url).isEqualTo("http://ergast.com/api/f1/2013/drivers/alonso.json");
    }

    @Test
    public void shouldCreateDriverInYearAndRoundUrl() {

        // when
        String url = ergastUrl().year(2013).round(2).drivers("alonso").url();

        // then
        assertThat(url).isEqualTo("http://ergast.com/api/f1/2013/2/drivers/alonso.json");
    }

    @Test
    public void shouldThrowIllegalArgExceptionWhenYearIsPrev1950() {

        // then
        expectedException.expect(IllegalArgumentException.class);

        // when
        ergastUrl().year(1949).drivers().url();

    }

}
