package com.gmaslowski.ergast.url;

import static com.gmaslowski.ergast.url.DriverUrlBuilder.driver;
import static com.gmaslowski.ergast.url.testdata.CircuitTestData.MONZA;
import static com.gmaslowski.ergast.url.testdata.ConstructorTestData.MCLAREN;
import static com.gmaslowski.ergast.url.testdata.DriverTestData.ALONSO;
import static org.fest.assertions.Assertions.assertThat;
import com.gmaslowski.ergast.test.AbstractUnitTest;
import org.junit.Test;

public class DriverUrlBuilderTest extends AbstractUnitTest {

    private String path;

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
    public void shouldCreateDriverUrlForCurrentYear() {
        // when
        path = driver(ALONSO).currentYear().path();

        // then
        assertThat(path).isEqualTo("/current/drivers/alonso");
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

    @Test
    public void shouldCreateDriverUrlForGivenCircuitId() {
        // when
        path = driver().drivingOnCircuit(MONZA).path();

        // then
        assertThat(path).isEqualTo("/circuits/monza/drivers");
    }

    @Test
    public void shouldCreateDriverUrlForGivenGridPosition() {
        // when
        path = driver().drivingOnGrid(4).path();

        // then
        assertThat(path).isEqualTo("/grid/4/drivers");
    }

    @Test
    public void shouldCreateDriverUrlForGivenResultPosition() {
        // when
        path = driver().finishedOnPosition(4).path();

        // then
        assertThat(path).isEqualTo("/results/4/drivers");
    }

    @Test
    public void shouldCreateDriverUrlForGivenStatus() {
        // when
        path = driver().withStatus("someStatus").path();

        // then
        assertThat(path).isEqualTo("/status/someStatus/drivers");
    }

    @Test
    public void shouldCreateDriverUrlForFastest() {
        // when
        path = driver().withFastest(7).path();

        // then
        assertThat(path).isEqualTo("/fastest/7/drivers");
    }

    @Test
    public void shouldCreateDriverCombo() {
        // when
        path = driver(ALONSO).currentYear().drivingOnCircuit(MONZA).drivingOnGrid(1).withFastest(7).path();

        // then
        assertThat(path).isEqualTo("/current/circuits/monza/grid/1/fastest/7/drivers/alonso");
    }
}
