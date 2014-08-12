package com.gmaslowski.ergast.url.builder;

import static com.gmaslowski.ergast.url.builder.DriverUrlBuilder.driver;
import static com.gmaslowski.ergast.url.testdata.DriverTestData.ALONSO;

public class DriverUrlBuilderTest extends AbstractUrlBuilderTest {

    @Override
    String givenPath() {
        return driver().path();
    }

    @Override
    String expectedPath() {
        return "/drivers";
    }

    @Override
    String givenPathWithValue() {
        return driver(ALONSO).path();
    }

    @Override
    String expectedPathWithValue() {
        return "/drivers/alonso";
    }
}
