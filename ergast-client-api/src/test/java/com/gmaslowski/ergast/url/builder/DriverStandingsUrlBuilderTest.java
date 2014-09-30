package com.gmaslowski.ergast.url.builder;

import static com.gmaslowski.ergast.url.builder.DriverStandingsUrlBuilder.driverStandings;

public class DriverStandingsUrlBuilderTest extends AbstractUrlBuilderTest {

    @Override
    String givenPath() {
        return driverStandings().path();
    }

    @Override
    String expectedPath() {
        return "/driverStandings";
    }

    @Override
    String givenPathWithValue() {
        return driverStandings(7).path();
    }

    @Override
    String expectedPathWithValue() {
        return "/driverStandings/7";
    }

}
