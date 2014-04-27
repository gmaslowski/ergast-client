package com.gmaslowski.ergast.paylod.url.modifier.xml;

import com.gmaslowski.ergast.payload.url.modifier.PayloadTypeUrlModifier;
import com.gmaslowski.ergast.payload.url.modifier.xml.XmlPayloadUrlModifier;
import com.gmaslowski.ergast.test.AbstractUnitTest;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class XmlPayloadUrlModifierTest extends AbstractUnitTest {

    private static final String URL_TO_MODIFY = "testString";

    @Test
    public void shouldAppendJsonSubstringToGivenUrl() {
        // given
        PayloadTypeUrlModifier urlModifier = new XmlPayloadUrlModifier();

        // when
        String result = urlModifier.modify(URL_TO_MODIFY);

        // then
        assertThat(result).isEqualTo(URL_TO_MODIFY + ".xml");
    }
}
