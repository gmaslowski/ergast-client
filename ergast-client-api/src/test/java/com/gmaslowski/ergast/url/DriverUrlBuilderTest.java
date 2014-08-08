package com.gmaslowski.ergast.url;

import static com.gmaslowski.ergast.url.DriverUrlBuilder.driver;
import static com.gmaslowski.ergast.url.testdata.ConstructorTestData.MCLAREN;
import static com.gmaslowski.ergast.url.testdata.DriverTestData.ALONSO;
import static org.fest.assertions.Assertions.assertThat;
import com.gmaslowski.ergast.test.AbstractUnitTest;
import org.junit.Test;

public class DriverUrlBuilderTest extends AbstractUnitTest {

    String path;

    @Test
    public void shouldCreateDriverUrlForAllDrivers() {
        // when
        path = driver().path();

        // then
        assertThat(path).isEqualTo("/drivers");
    }

    @Test
    public void shouldCreateDriverUrlForGivenDriver() {
        // when
        path = driver(ALONSO).path();

        // then
        assertThat(path).isEqualTo("/drivers/alonso");
    }

    @Test
    public void shouldCreateDriverUrlForGivenDriverInGivenYear() {
        // when
        path = driver(ALONSO).drivingInYear(2004).path();

        // then
        assertThat(path).isEqualTo("/2004/drivers/alonso");
    }

    @Test
    public void shouldCreateDriverUrlForGivenDriverDrivingForGivenConstructor() {
        // when
        path = driver().drivingForConstructor(MCLAREN).path();

        // then
        assertThat(path).isEqualTo("/constructors/mclaren/drivers");
    }

}
