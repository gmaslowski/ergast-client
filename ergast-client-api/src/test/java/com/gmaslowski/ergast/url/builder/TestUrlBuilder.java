package com.gmaslowski.ergast.url.builder;

class TestUrlBuilder extends UrlBuilderTemplate {

    public static TestUrlBuilder testUrlBuilder() {
        return new TestUrlBuilder();
    }

    private TestUrlBuilder() {
    }

    @Override
    public String buildUrlEnding() {
        return "";
    }
}
