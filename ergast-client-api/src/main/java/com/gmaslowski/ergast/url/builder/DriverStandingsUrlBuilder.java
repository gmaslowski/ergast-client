package com.gmaslowski.ergast.url.builder;

import static com.google.common.base.Preconditions.checkNotNull;

public class DriverStandingsUrlBuilder extends UrlBuilderTemplate {

    private Integer position;

    public DriverStandingsUrlBuilder() {
    }

    private DriverStandingsUrlBuilder(Integer position) {
        this.position = position;
    }

    public static UrlBuilderTemplate driverStandings() {
        return new DriverStandingsUrlBuilder();
    }

    public static UrlBuilderTemplate driverStandings(Integer position) {
        return new DriverStandingsUrlBuilder(checkNotNull(position));
    }

    @Override
    protected String buildUrlEnding() {
        if (position == null) {
            return SLASH + DRIVER_STANDINGS_PATH;
        }

        return SLASH + DRIVER_STANDINGS_PATH + SLASH + position;
    }
}
