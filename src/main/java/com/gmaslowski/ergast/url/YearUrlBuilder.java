package com.gmaslowski.ergast.url;

import static com.gmaslowski.ergast.url.ConstructorsUrlBuilder.constructorsBuilder;
import static com.gmaslowski.ergast.url.DriversUrlBuilder.driversBuilder;
import static com.gmaslowski.ergast.url.SeasonsUrlBuilder.seasonsBuilder;
import static com.google.common.base.Preconditions.checkArgument;

public class YearUrlBuilder extends AbstractErgastUrlBuilder<YearUrlBuilder> {

    private YearUrlBuilder(ErgastUrl ergastUrl) {
        this.ergastUrl = ergastUrl;
    }

    static YearUrlBuilder yearBuilder(ErgastUrl ergastUrl) {
        return new YearUrlBuilder(ergastUrl);
    }

    public YearUrlBuilder year(Integer year) {
        checkArgument(year >= 1950, String.format("[year=%s]. Sorry, but F1 started first in 1950 UK Silverstone.", year));
        ergastUrl.addUrlPart(year.toString());
        return this;
    }

    public YearUrlBuilder round(Integer round) {
        ergastUrl.addUrlPart(round.toString());
        return this;
    }

    public DriversUrlBuilder drivers() {
        return driversBuilder(ergastUrl).drivers();
    }

    public DriversUrlBuilder drivers(String driverId) {
        return driversBuilder(ergastUrl).drivers(driverId);
    }

    public ConstructorsUrlBuilder constructors() {
        return constructorsBuilder(ergastUrl).constructors();
    }

    public ConstructorsUrlBuilder constructors(String constructorId) {
        return constructorsBuilder(ergastUrl).constructors(constructorId);
    }

    public SeasonsUrlBuilder seasons() {
        return seasonsBuilder(ergastUrl).seasons();
    }

    @Override
    protected YearUrlBuilder getConcreteBuilder() {
        return this;
    }
}
