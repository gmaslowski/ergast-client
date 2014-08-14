package com.gmaslowski.ergast.url.builder;

import com.gmaslowski.ergast.test.AbstractUnitTest;
import org.junit.Test;

import static com.gmaslowski.ergast.url.builder.SeasonUrlBuilder.season;
import static org.fest.assertions.Assertions.assertThat;

public class SeasonUrlBuilderTest extends AbstractUnitTest {

	@Test
	public void shouldAppendGivenPathToUrl() {
		// when
		String given = season().path();

		// then
		assertThat(given).isEqualTo("/seasons");
	}
}
