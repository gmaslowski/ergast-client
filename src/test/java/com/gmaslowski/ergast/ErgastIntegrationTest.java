package com.gmaslowski.ergast;

import com.gmaslowski.ergast.entity.EGResponse;
import com.gmaslowski.ergast.url.ErgastUrl;
import org.junit.Test;

import static com.gmaslowski.ergast.url.ErgastUrlBuilder.ergastUrl;

public class ErgastIntegrationTest {

    private Ergast ergast;

    @Test
    public void shouldRetrieveData() {
        // given
        ergast = Ergast.defaultInstance();
        ErgastUrl ergastUrl = ergastUrl().drivers("alonso").build();

        // when
        EGResponse response = ergast.request(ergastUrl);

        // then
        System.out.println(response);
    }

}
