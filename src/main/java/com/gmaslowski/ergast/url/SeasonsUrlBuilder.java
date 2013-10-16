package com.gmaslowski.ergast.url;

import java.util.List;

public class SeasonsUrlBuilder extends AbstractErgastUrlBuilder {

    public static final String SEASONS = "seasons";

    private SeasonsUrlBuilder(List<String> ergastUrlParts) {
        this.ergastUrlParts = ergastUrlParts;
    }

    static SeasonsUrlBuilder seasonsBuilder(List<String> ergastUrlParts) {
        return new SeasonsUrlBuilder(ergastUrlParts);
    }

    SeasonsUrlBuilder seasons() {
        ergastUrlParts.add(SEASONS);
        return this;
    }
}
