package com.gmaslowski.ergast.url;

import java.util.List;

import static com.gmaslowski.ergast.url.ConstructorsUrlBuilder.constructorsBuilder;
import static com.gmaslowski.ergast.url.DriversUrlBuilder.driversBuilder;
import static com.gmaslowski.ergast.url.SeasonsUrlBuilder.seasonsBuilder;
import static com.google.common.base.Preconditions.checkArgument;

public class YearUrlBuilder extends AbstractErgastUrlBuilder {

    private YearUrlBuilder(List<String> ergastUrlParts) {
        this.ergastUrlParts = ergastUrlParts;
    }

    static YearUrlBuilder yearBuilder(List<String> ergastUrlParts) {
        return new YearUrlBuilder(ergastUrlParts);
    }

    public YearUrlBuilder year(Integer year) {
        checkArgument(year >= 1950, String.format("[year=%s]. Sorry, but F1 started first in 1950 UK Silverstone.", year));
        ergastUrlParts.add(year.toString());
        return this;
    }

    public YearUrlBuilder round(Integer round) {
        ergastUrlParts.add(round.toString());
        return this;
    }

    public DriversUrlBuilder drivers() {
        return driversBuilder(ergastUrlParts).drivers();
    }

    public DriversUrlBuilder drivers(String driverId) {
        return driversBuilder(ergastUrlParts).drivers(driverId);
    }

    public ConstructorsUrlBuilder constructors() {
        return constructorsBuilder(ergastUrlParts).constructors();
    }

    public ConstructorsUrlBuilder constructors(String constructorId) {
        return constructorsBuilder(ergastUrlParts).constructors(constructorId);
    }

    public SeasonsUrlBuilder seasons() {
        return seasonsBuilder(ergastUrlParts).seasons();
    }

}
