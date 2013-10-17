package com.gmaslowski.ergast.url;

public class SeasonsUrlBuilder extends AbstractErgastUrlBuilder<SeasonsUrlBuilder> {

    public static final String SEASONS = "seasons";

    private SeasonsUrlBuilder(ErgastUrl ergastUrl) {
        this.ergastUrl = ergastUrl;
    }

    static SeasonsUrlBuilder seasonsBuilder(ErgastUrl ergastUrl) {
        return new SeasonsUrlBuilder(ergastUrl);
    }

    SeasonsUrlBuilder seasons() {
        ergastUrl.addUrlPart(SEASONS);
        return this;
    }

    @Override
    protected SeasonsUrlBuilder getConcreteBuilder() {
        return this;
    }
}
