package com.gmaslowski.ergast.url;

import static com.gmaslowski.ergast.url.DriversUrlBuilder.driversBuilder;
import static com.gmaslowski.ergast.url.SeasonsUrlBuilder.seasonsBuilder;

public class ErgastUrlBuilder extends AbstractErgastUrlBuilder<ErgastUrlBuilder> {

    public static final String DEFAULT_ERGAST_URL = "http://ergast.com/api/f1";

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

    public YearUrlBuilder year(Integer year) {
        return YearUrlBuilder.yearBuilder(ergastUrl).year(year);
    }

    public DriversUrlBuilder drivers() {
        return driversBuilder(ergastUrl).drivers();
    }

    public DriversUrlBuilder drivers(String driverId) {
        return driversBuilder(ergastUrl).drivers(driverId);
    }

    public SeasonsUrlBuilder seasons() {
        return seasonsBuilder(ergastUrl).seasons();
    }

    @Override
    protected ErgastUrlBuilder getConcreteBuilder() {
        return this;
    }
}
