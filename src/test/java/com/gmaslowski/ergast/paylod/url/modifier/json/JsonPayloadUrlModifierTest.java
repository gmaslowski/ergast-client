package com.gmaslowski.ergast.paylod.url.modifier.json;

import com.gmaslowski.ergast.payload.url.modifier.json.JsonPayloadUrlModifier;
import org.junit.Test;
import pl.kikko.test.unit.AbstractUnitTest;

import static org.fest.assertions.Assertions.assertThat;

public class JsonPayloadUrlModifierTest extends AbstractUnitTest {

    private static final String URL_TO_MODIFY = "testString";

    @Test
    public void shouldAppendJsonSubstringToGivenUrl() {
        // given
        JsonPayloadUrlModifier urlModifier = new JsonPayloadUrlModifier();

        // when
        String result = urlModifier.modify(URL_TO_MODIFY);

        // then
        assertThat(result).isEqualTo(URL_TO_MODIFY + ".json");
    }
}
