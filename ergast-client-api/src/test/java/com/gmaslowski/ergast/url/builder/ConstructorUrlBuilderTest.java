package com.gmaslowski.ergast.url.builder;

import static com.gmaslowski.ergast.url.builder.ConstructorUrlBuilder.constructor;
import static com.gmaslowski.ergast.url.testdata.ConstructorTestData.MCLAREN;

public class ConstructorUrlBuilderTest extends AbstractUrlBuilderTest {

    @Override
    String givenPath() {
        return constructor().path();
    }

    @Override
    String expectedPath() {
        return "/constructors";
    }

    @Override
    String givenPathWithValue() {
        return constructor(MCLAREN).path();
    }

    @Override
    String expectedPathWithValue() {
        return "/constructors/mclaren";
    }
}
