package com.gmaslowski.ergast.url.builder;

public class PitStopsUrlBuilder extends UrlBuilderTemplate {

    private Integer pitStopNumber;

    private PitStopsUrlBuilder() {
    }

    private PitStopsUrlBuilder(Integer pitStopNumber) {
        this.pitStopNumber = pitStopNumber;
    }

    public static UrlBuilderTemplate pitStops() {
        return new PitStopsUrlBuilder();
    }

    public static UrlBuilderTemplate pitStops(Integer pitStopNumber) {
        return new PitStopsUrlBuilder(pitStopNumber);
    }

    @Override
    protected String buildUrlEnding() {
        if (pitStopNumber == null) {
            return SLASH + PITSTOP_PATH;
        }

        return SLASH + PITSTOP_PATH + SLASH + pitStopNumber;

    }
}
