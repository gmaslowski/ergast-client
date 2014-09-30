package com.gmaslowski.ergast.url.builder;

public class ConstructorStandingsUrlBuilder extends UrlBuilderTemplate {

    private Integer position;

    private ConstructorStandingsUrlBuilder() {
    }

    private ConstructorStandingsUrlBuilder(Integer position) {
        this.position = position;
    }

    public static UrlBuilderTemplate constructorStandings() {
        return new ConstructorStandingsUrlBuilder();
    }

    public static UrlBuilderTemplate constructorStandings(Integer position) {
        return new ConstructorStandingsUrlBuilder(position);
    }

    @Override
    protected String buildUrlEnding() {
        if (position == null) {
            return SLASH + CONSTRUCTOR_STANDINGS_PATH;
        }
        return SLASH + CONSTRUCTOR_STANDINGS_PATH + SLASH + position;
    }
}
