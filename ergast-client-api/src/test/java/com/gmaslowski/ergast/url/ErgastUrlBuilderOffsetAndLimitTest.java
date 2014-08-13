package com.gmaslowski.ergast.url;

import com.gmaslowski.ergast.test.AbstractUnitTest;
import org.junit.Test;

import static com.gmaslowski.ergast.url.ErgastUrl.DEFAULT_LIMIT;
import static com.gmaslowski.ergast.url.ErgastUrl.DEFAULT_OFFSET;
import static com.gmaslowski.ergast.url.ErgastUrlBuilder.ergastUrl;
import static org.fest.assertions.Assertions.assertThat;

public class ErgastUrlBuilderOffsetAndLimitTest extends AbstractUnitTest {

	private String url;

	@Test
    public void shouldCreateUrlWithGivenOffsetAndLimitSet() {
        // when
		url = ergastUrl().offset(13).limit(7).build().urlString();

        // then
        assertThat(url).contains("limit=7");
        assertThat(url).contains("offset=13");
    }

    @Test
    public void shouldCreateUrlWithGivenOffsetAndUseDefaultLimitValue() {
        // when
        url = ergastUrl().offset(13).build().urlString();

        // then
        assertThat(url).contains(String.format("limit=%s", DEFAULT_LIMIT));
        assertThat(url).contains("offset=13");
    }

    @Test
    public void shouldCreateUrlWithGivenLimitAndUseDefaultOffsetValue() {
        // when
        url = ergastUrl().limit(7).build().urlString();

        // then
        assertThat(url).contains(String.format("offset=%s", DEFAULT_OFFSET));
        assertThat(url).contains("limit=7");
    }

    @Test
    public void shouldCreateUrlWithoutLimitAndOffsetWhenNotSet() {
        // when
        url = ergastUrl().build().urlString();

        // then
        assertThat(url).doesNotContain("limit=");
        assertThat(url).doesNotContain("offset=");
    }

}
