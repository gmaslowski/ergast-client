package com.gmaslowski.ergast.url;

import com.gmaslowski.ergast.test.AbstractUnitTest;
import org.junit.Test;

import static com.gmaslowski.ergast.url.ErgastUrlBuilder.ergastUrl;
import static org.fest.assertions.Assertions.assertThat;


public class ErgastUrlBuilderTest extends AbstractUnitTest {

    @Test
    public void shouldCreateDriverInYearUrl() {

        // when
        String url = ergastUrl().year(2013).drivers("alonso").build().urlString();

        // then
        assertThat(url).isEqualTo("http://ergast.com/api/f1/2013/drivers/alonso");
    }

    @Test
    public void shouldCreateDriverInYearAndRoundUrl() {

        // when
        String url = ergastUrl().year(2013).round(2).drivers("alonso").build().urlString();

        // then
        assertThat(url).isEqualTo("http://ergast.com/api/f1/2013/2/drivers/alonso");
    }

    @Test
    public void shouldThrowIllegalArgExceptionWhenYearIsPrev1950() {

        // then
        expectedException.expect(IllegalArgumentException.class);

        // when
        ergastUrl().year(1949).drivers().build();

    }

    @Test
    public void shouldCreateDriverUrl() {
        // when
        String url = ergastUrl().drivers("alonso").build().urlString();

        // then
        assertThat(url).isEqualTo("http://ergast.com/api/f1/drivers/alonso");
    }

    @Test
    public void shouldCreateDriversUrl() {
        // when
        String url = ergastUrl().drivers().build().urlString();

        // then
        assertThat(url).isEqualTo("http://ergast.com/api/f1/drivers");
    }

    @Test
    public void shouldCreateSeasonForADriverUrl() {
        // when
        String url = ergastUrl().drivers("alonso").seasons().build().urlString();

        // then
        assertThat(url).isEqualTo("http://ergast.com/api/f1/drivers/alonso/seasons");
    }

    @Test
    public void shouldCreateSeasonsUrl() {
        // when
        String url = ergastUrl().seasons().build().urlString();

        // then
        assertThat(url).isEqualTo("http://ergast.com/api/f1/seasons");
    }
}
