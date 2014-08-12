package com.gmaslowski.ergast;

import static com.gmaslowski.ergast.Ergast.ergast;
import static com.gmaslowski.ergast.payload.request.basic.BasicPayloadRequester.basicPayloadRequester;
import static com.gmaslowski.ergast.url.ErgastUrlBuilder.ergastUrl;
import static java.util.concurrent.TimeUnit.SECONDS;
import com.gmaslowski.ergast.entity.baredata.EGResponse;
import com.gmaslowski.ergast.url.ErgastUrl;
import org.junit.Test;

public class ErgastIntegrationTest {

    private Ergast ergast;
    private int timeout = (int) SECONDS.toMillis(5L);

    @Test
    public void shouldRetrieveData() {
        // given
        ergast = ergast(basicPayloadRequester(timeout, timeout));
        ErgastUrl ergastUrl = ergastUrl().drivers("alonso").limit(0).offset(0).build();

        // when
        EGResponse response = ergast.request(ergastUrl);

        // then
        System.out.println(response);
    }

}
