package com.gmaslowski.ergast.url;

import org.junit.Test;

import static com.gmaslowski.ergast.url.ErgastUrlBuilder.ergastUrl;
import static org.fest.assertions.Assertions.assertThat;

public class DriversUrlBuilderTest {

    @Test
    public void shouldCreateDriverUrl() {
        // when
        String url = ergastUrl().drivers("alonso").url();

        // then
        assertThat(url).isEqualTo("http://ergast.com/api/f1/drivers/alonso.json");
    }

    @Test
    public void shouldCreateDriversUrl() {
        // when
        String url = ergastUrl().drivers().url();

        // then
        assertThat(url).isEqualTo("http://ergast.com/api/f1/drivers.json");
    }

    @Test
    public void shouldCreateDriverInYearUrl() {
        // when
        String url = ergastUrl().year(2013).drivers("alonso").url();

        // then
        assertThat(url).isEqualTo("http://ergast.com/api/f1/2013/drivers/alonso.json");
    }

    @Test
    public void shouldCreateDriverInYearAndMonthUrl() {
        // when
        String url = ergastUrl().year(2013).month(2).drivers("alonso").url();

        // then
        assertThat(url).isEqualTo("http://ergast.com/api/f1/2013/2/drivers/alonso.json");
    }

}
