package com.gmaslowski.ergast.url;

import com.gmaslowski.ergast.url.exception.ErgastUrlException;
import com.gmaslowski.ergast.payload.url.modifier.PayloadTypeUrlModifier;
import org.junit.Test;
import pl.kikko.test.unit.AbstractUnitTest;

import static com.gmaslowski.ergast.url.ErgastUrlBuilder.ergastUrl;

public class ErgastUrlTest extends AbstractUnitTest {

    private PayloadTypeUrlModifier dontModifyUrlModifier = new PayloadTypeUrlModifier() {
        @Override
        public String modify(String url) {
            return url;
        }
    };

    @Test
    public void shouldThrowErgastUrlExceptionOnInvalidUrl() {
        // then
        expectedException.expect(ErgastUrlException.class);

        // when
        ergastUrl("meinvalid!").build().url(dontModifyUrlModifier);
    }

}
