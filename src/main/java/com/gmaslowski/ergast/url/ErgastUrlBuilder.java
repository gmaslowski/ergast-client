package com.gmaslowski.ergast.url;

import static com.gmaslowski.ergast.url.DriversUrlBuilder.driversBuilder;
import static com.gmaslowski.ergast.url.SeasonsUrlBuilder.seasonsBuilder;
import static com.google.common.collect.Lists.newArrayList;

public class ErgastUrlBuilder extends AbstractErgastUrlBuilder {

    public static final String DEFAULT_ERGAST_URL = "http://ergast.com/api/f1";

    private ErgastUrlBuilder(String ergastUrl) {
        ergastUrlParts = newArrayList();
        ergastUrlParts.add(ergastUrl);
    }

    public static ErgastUrlBuilder ergastUrl() {
        return new ErgastUrlBuilder(DEFAULT_ERGAST_URL);
    }

    public static ErgastUrlBuilder ergastUrl(String ergastUrl) {
        return new ErgastUrlBuilder(ergastUrl);
    }

    public YearUrlBuilder year(Integer year) {
        return YearUrlBuilder.yearBuilder(ergastUrlParts).year(year);
    }

    public DriversUrlBuilder drivers() {
        return driversBuilder(ergastUrlParts).drivers();
    }

    public DriversUrlBuilder drivers(String driverId) {
        return driversBuilder(ergastUrlParts).drivers(driverId);
    }

    public SeasonsUrlBuilder seasons() {
        return seasonsBuilder(ergastUrlParts).seasons();
    }
}
