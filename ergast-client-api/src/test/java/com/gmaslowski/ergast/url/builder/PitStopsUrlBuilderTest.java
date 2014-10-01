package com.gmaslowski.ergast.url.builder;

import static com.gmaslowski.ergast.url.builder.PitStopsUrlBuilder.pitStops;

public class PitStopsUrlBuilderTest extends AbstractUrlBuilderTest{

    @Override
    String givenPath() {
        return pitStops().path();
    }

    @Override
    String expectedPath() {
        return "/pitstops";
    }

    @Override
    String givenPathWithValue() {
        return pitStops(7).path();
    }

    @Override
    String expectedPathWithValue() {
        return "/pitstops/7";
    }
}
