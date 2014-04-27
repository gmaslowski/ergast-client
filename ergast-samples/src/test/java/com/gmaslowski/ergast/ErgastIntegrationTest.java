package com.gmaslowski.ergast;

import com.gmaslowski.ergast.entity.baredata.EGResponse;
import com.gmaslowski.ergast.url.ErgastUrl;
import org.junit.Test;

import static com.gmaslowski.ergast.Ergast.ergast;
import static com.gmaslowski.ergast.url.ErgastUrlBuilder.ergastUrl;

public class ErgastIntegrationTest {

    private Ergast ergast;

    @Test
    public void shouldRetrieveData() {
        // given
        ergast = ergast();
        ErgastUrl ergastUrl = ergastUrl().drivers("alonso").limit(0).offset(0).build();

        // when
        EGResponse response = ergast.request(ergastUrl);

        // then
        System.out.println(response);
    }

}
