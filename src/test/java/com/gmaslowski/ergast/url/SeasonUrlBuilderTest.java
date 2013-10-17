package com.gmaslowski.ergast.url;

import org.junit.Test;

import static com.gmaslowski.ergast.url.ErgastUrlBuilder.ergastUrl;
import static org.fest.assertions.Assertions.assertThat;

public class SeasonUrlBuilderTest {

    @Test
    public void shouldCreateSeasonForADriverUrl() {
        // when
        String url = ergastUrl().drivers("alonso").seasons().url();

        // then
        assertThat(url).isEqualTo("http://ergast.com/api/f1/drivers/alonso/seasons.json");
    }

    @Test
    public void shouldCreateSeasonsUrl() {
        // when
        String url = ergastUrl().seasons().url();

        // then
        assertThat(url).isEqualTo("http://ergast.com/api/f1/seasons.json");
    }
}
