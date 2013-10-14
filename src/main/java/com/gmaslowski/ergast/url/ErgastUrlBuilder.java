package com.gmaslowski.ergast.url;

import static com.google.common.base.Joiner.on;

public class ErgastUrlBuilder {

    public static final String DEFAULT_ERGAST_URL = "http://ergast.com/api/f1";
    private static final String SLASH = "/";
    private static final String DRIVERS = "drivers";
    private static final String DOT = ".";
    private static final String JSON = "json";

    private String ergastUrl;

    private ErgastUrlBuilder(String ergastUrl) {
        this.ergastUrl = ergastUrl;
    }

    public static ErgastUrlBuilder createUrl() {
        return new ErgastUrlBuilder(DEFAULT_ERGAST_URL);
    }

    public static ErgastUrlBuilder createUrl(String ergastUrl) {
        return new ErgastUrlBuilder(ergastUrl);
    }

    public ErgastUrlBuilder year(Integer year) {
        ergastUrl = on(SLASH).join(ergastUrl, year);
        return this;
    }

    public ErgastUrlBuilder drivers() {
        ergastUrl = on(SLASH).join(ergastUrl, DRIVERS);
        return this;
    }

    public ErgastUrlBuilder drivers(String driverId) {
        ergastUrl = on(SLASH).join(ergastUrl, DRIVERS, driverId);
        return this;
    }

    public String url() {
        return on(DOT).join(ergastUrl, JSON);
    }

}
