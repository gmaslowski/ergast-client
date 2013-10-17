package com.gmaslowski.ergast.url;

import static com.google.common.base.Preconditions.checkArgument;

public class ErgastUrlBuilder {

    public static final String DEFAULT_ERGAST_URL = "http://ergast.com/api/f1";

    private static final String SEASONS = "seasons";
    private static final String DRIVERS = "drivers";
    private static final String CONSTRUCTORS = "constructors";

    private final ErgastUrl ergastUrl;

    private ErgastUrlBuilder(String ergastUrl) {
        this.ergastUrl = new ErgastUrl();
        this.ergastUrl.addUrlPart(ergastUrl);
    }

    public static ErgastUrlBuilder ergastUrl() {
        return new ErgastUrlBuilder(DEFAULT_ERGAST_URL);
    }

    public static ErgastUrlBuilder ergastUrl(String ergastUrl) {
        return new ErgastUrlBuilder(ergastUrl);
    }

    public ErgastUrlBuilder seasons() {
        ergastUrl.addUrlPart(SEASONS);
        return this;
    }

    public ErgastUrlBuilder drivers() {
        ergastUrl.addUrlPart(DRIVERS);
        return this;
    }

    public ErgastUrlBuilder drivers(String driverId) {
        ergastUrl.addUrlPart(DRIVERS);
        ergastUrl.addUrlPart(driverId);
        return this;
    }

    public ErgastUrlBuilder constructors() {
        ergastUrl.addUrlPart(CONSTRUCTORS);
        return this;
    }

    public ErgastUrlBuilder constructors(String constructorId) {
        ergastUrl.addUrlPart(CONSTRUCTORS);
        ergastUrl.addUrlPart(constructorId);
        return this;
    }

    public ErgastUrlBuilder year(Integer year) {
        checkArgument(year >= 1950, String.format("[year=%s]. Sorry, but F1 started first in 1950 UK Silverstone.", year));
        ergastUrl.addUrlPart(year.toString());
        return this;
    }

    public ErgastUrlBuilder round(Integer round) {
        ergastUrl.addUrlPart(round.toString());
        return this;
    }

    public ErgastUrlBuilder limit(Integer limit) {
        ergastUrl.limit(limit);
        return this;
    }

    public ErgastUrlBuilder offset(Integer offset) {
        ergastUrl.offset(offset);
        return this;
    }

    public String url() {
        return ergastUrl.url().concat(".json");
    }
}
