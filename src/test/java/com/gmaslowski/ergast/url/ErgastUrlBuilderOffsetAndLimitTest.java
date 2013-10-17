package com.gmaslowski.ergast.url;

import org.junit.Test;

import static com.gmaslowski.ergast.url.ErgastUrl.DEFAULT_LIMIT;
import static com.gmaslowski.ergast.url.ErgastUrl.DEFAULT_OFFSET;
import static com.gmaslowski.ergast.url.ErgastUrlBuilder.ergastUrl;
import static org.fest.assertions.Assertions.assertThat;

public class ErgastUrlBuilderOffsetAndLimitTest {

    @Test
    public void shouldCreateUrlWithGivenOffsetAndLimitSet() {
        // when
        String url = ergastUrl().offset(13).limit(7).url();

        // then
        assertThat(url).contains("limit=7");
        assertThat(url).contains("offset=13");
    }

    @Test
    public void shouldCreateUrlWithGivenOffsetAndUseDefaultLimitValue() {
        // when
        String url = ergastUrl().offset(13).url();

        // then
        assertThat(url).contains(String.format("limit=%s", DEFAULT_LIMIT));
        assertThat(url).contains("offset=13");
    }

    @Test
    public void shouldCreateUrlWithGivenLimitAndUseDefaultOffsetValue() {
        // when
        String url = ergastUrl().limit(7).url();

        // then
        assertThat(url).contains(String.format("offset=%s", DEFAULT_OFFSET));
        assertThat(url).contains("limit=7");
    }

    @Test
    public void shouldCreateUrlWithoutLimitAndOffsetWhenNotSet() {
        // when
        String url = ergastUrl().url();

        // then
        assertThat(url).doesNotContain("limit=");
        assertThat(url).doesNotContain("offset=");
    }

}
