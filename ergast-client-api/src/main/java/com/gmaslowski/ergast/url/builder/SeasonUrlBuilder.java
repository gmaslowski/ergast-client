package com.gmaslowski.ergast.url.builder;

public class SeasonUrlBuilder extends UrlBuilderTemplate {

    public static SeasonUrlBuilder season() {
        return new SeasonUrlBuilder();
    }

    private SeasonUrlBuilder() {
    }

    @Override
    public String buildUrlEnding() {
        return "/seasons";
    }
}
