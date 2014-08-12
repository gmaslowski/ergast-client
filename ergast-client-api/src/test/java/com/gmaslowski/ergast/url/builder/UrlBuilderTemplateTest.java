package com.gmaslowski.ergast.url.builder;

import static com.gmaslowski.ergast.url.builder.TestUrlBuilder.testUrlBuilder;
import static com.gmaslowski.ergast.url.testdata.CircuitTestData.MONZA;
import static com.gmaslowski.ergast.url.testdata.ConstructorTestData.MCLAREN;
import static com.gmaslowski.ergast.url.testdata.DriverTestData.ALONSO;
import static junitparams.JUnitParamsRunner.$;
import static org.fest.assertions.Assertions.assertThat;
import com.gmaslowski.ergast.test.AbstractUnitTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class UrlBuilderTemplateTest extends AbstractUnitTest {

    private String path;

    @Test
    public void shouldCreateUrlWithoutFilters() {
        // when
        path = testUrlBuilder().path();

        // then
        assertThat(path).isEqualTo("");
    }

    @Test
    public void shouldCreateUrlWithDriverFilter() {
        // when
        path = testUrlBuilder().byDriver(ALONSO).path();

        // then
        assertThat(path).isEqualTo("/drivers/alonso");
    }

    @Test
    public void shouldCreateUrlWithCurrentYear() {
        // when
        path = testUrlBuilder().currentYear().path();

        // then
        assertThat(path).isEqualTo("/current");
    }

    @Test
    public void shouldCreateUrlForGivenYear() {
        // when
        path = testUrlBuilder().inYear(2004).path();

        // then
        assertThat(path).isEqualTo("/2004");
    }

    @Test
    public void shouldCreateUrlWithConstructorFilter() {
        // when
        path = testUrlBuilder().byConstructor(MCLAREN).path();

        // then
        assertThat(path).isEqualTo("/constructors/mclaren");
    }

    @Test
    public void shouldCreateUrlWithCircuitFilter() {
        // when
        path = testUrlBuilder().onCircuit(MONZA).path();

        // then
        assertThat(path).isEqualTo("/circuits/monza");
    }

    @Test
    public void shouldCreateUrlWithGridPositionFilter() {
        // when
        path = testUrlBuilder().onGrid(4).path();

        // then
        assertThat(path).isEqualTo("/grid/4");
    }

    @Test
    public void shouldCreateUrlWithResultPositionFilter() {
        // when
        path = testUrlBuilder().onPosition(4).path();

        // then
        assertThat(path).contains("/results/4");
    }

    @Test
    public void shouldCreateUrlWithStatusFilter() {
        // when
        path = testUrlBuilder().withStatus("someStatus").path();

        // then
        assertThat(path).contains("/status/someStatus");
    }

    @Test
    public void shouldCreateUrlWithFastestFilter() {
        // when
        path = testUrlBuilder().withFastest(7).path();

        // then
        assertThat(path).contains("/fastest/7");
    }

    @Test
    public void shouldAppendCustomUrlAtTheEndOfPath() {
        // given
        UrlBuilderTemplate urlBuilder = new UrlBuilderTemplate() {
            @Override
            public String buildUrlEnding() {
                return "/appending";
            }
        };

        // when
        path = urlBuilder.byConstructor(MCLAREN).byDriver(ALONSO).onCircuit(MONZA).onGrid(1).path();


        // then
        assertThat(path).endsWith("/appending");
    }

    @Test
    @Parameters(method = "comboFilters")
    public void shouldCreateUrlWithComboFilters(String givenPath, String expectedPart) {
        // then
        assertThat(givenPath).contains(expectedPart);
    }

    private Object comboFilters() {
        String comboPath = testUrlBuilder()
                .currentYear()
                .byConstructor(MCLAREN)
                .byDriver(ALONSO)
                .onCircuit(MONZA)
                .onGrid(1)
                .onPosition(1)
                .withFastest(7)
                .withStatus("ble")
                .path();

        return $($(comboPath, "/constructors/mclaren"),
                $(comboPath, "/drivers/alonso"),
                $(comboPath, "/grid/1"),
                $(comboPath, "/results/1"),
                $(comboPath, "/fastest/7"),
                $(comboPath, "/circuits/monza"),
                $(comboPath, "/status/ble"));
    }
}

