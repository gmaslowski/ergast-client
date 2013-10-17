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
}
