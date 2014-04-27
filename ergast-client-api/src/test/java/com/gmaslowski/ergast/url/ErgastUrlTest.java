package com.gmaslowski.ergast.url;

import com.gmaslowski.ergast.payload.url.modifier.PayloadTypeUrlModifier;
import com.gmaslowski.ergast.test.AbstractUnitTest;
import com.gmaslowski.ergast.url.exception.ErgastUrlException;
import org.junit.Test;

import java.net.URL;

import static com.gmaslowski.ergast.url.ErgastUrlBuilder.ergastUrl;
import static org.fest.assertions.Assertions.assertThat;

public class ErgastUrlTest extends AbstractUnitTest {

    private PayloadTypeUrlModifier dontModifyUrlModifier = new PayloadTypeUrlModifier() {
        @Override
        public String modify(String url) {
            return url;
        }
    };

    private PayloadTypeUrlModifier appendJsonUrlModifier = new PayloadTypeUrlModifier() {
        @Override
        public String modify(String url) {
            return url.concat(".json");
        }
    };

    @Test
    public void shouldThrowErgastUrlExceptionOnInvalidUrl() {
        // then
        expectedException.expect(ErgastUrlException.class);

        // when
        ergastUrl("meinvalid!").build().url(dontModifyUrlModifier);
    }

    @Test
    public void shouldNotThrowErgastUrlExceptionForValidUrl() {
        // when
        ergastUrl().year(2011).round(1).drivers().limit(1).build().url(dontModifyUrlModifier);

        // then expect nothing
    }

    @Test
    public void shouldAddModifierAndThanAppendLimitAndOffset() {
        // when
        URL url = ergastUrl("http://url").drivers("alonso").limit(0).offset(0).build().url(appendJsonUrlModifier);

        // then
        assertThat(url.getPath()).isEqualTo("/drivers/alonso.json");
        assertThat(url.getQuery()).isEqualTo("limit=0&offset=0");
    }


}
