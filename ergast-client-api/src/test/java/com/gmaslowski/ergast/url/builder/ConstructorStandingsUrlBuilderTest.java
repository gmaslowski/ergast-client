package com.gmaslowski.ergast.url.builder;

import static com.gmaslowski.ergast.url.builder.ConstructorStandingsUrlBuilder.constructorStandings;

public class ConstructorStandingsUrlBuilderTest extends AbstractUrlBuilderTest {

    @Override
    String givenPath() {
        return constructorStandings().path();
    }

    @Override
    String expectedPath() {
        return "/constructorStandings";
    }

    @Override
    String givenPathWithValue() {
        return constructorStandings(7).path();
    }

    @Override
    String expectedPathWithValue() {
        return "/constructorStandings/7";
    }
}
