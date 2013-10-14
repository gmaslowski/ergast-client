package com.gmaslowski.ergast.url;

import org.junit.Test;

import static com.gmaslowski.ergast.url.ErgastUrlBuilder.createUrl;
import static org.fest.assertions.Assertions.assertThat;

public class ErgastUrlBuilderTest {

    @Test
    public void shouldCreateDriverInYearUrl() {

        // when
        String url = createUrl().year(2013).drivers("alonso").url();

        // then
        assertThat(url).isEqualTo("http://ergast.com/api/f1/2013/drivers/alonso");
    }

}
