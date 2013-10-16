package com.gmaslowski.ergast.url;

import java.util.List;

import static com.gmaslowski.ergast.url.DriversUrlBuilder.driversBuilder;
import static com.google.common.base.Preconditions.checkArgument;

public class YearUrlBuilder extends AbstractErgastUrlBuilder {

    private YearUrlBuilder(List<String> ergastUrlParts) {
        this.ergastUrlParts = ergastUrlParts;
    }

    static YearUrlBuilder yearBuilder(List<String> ergastUrlParts) {
        return new YearUrlBuilder(ergastUrlParts);
    }

    public YearUrlBuilder year(Integer year) {
        checkArgument(year >= 1950);
        ergastUrlParts.add(year.toString());
        return this;
    }

    public YearUrlBuilder month(Integer month) {
        checkArgument(month > 1 && month <= 12);
        ergastUrlParts.add(month.toString());
        return this;
    }

    public DriversUrlBuilder drivers() {
        return driversBuilder(ergastUrlParts).drivers();
    }

    public DriversUrlBuilder drivers(String driverId) {
        return driversBuilder(ergastUrlParts).drivers(driverId);
    }

}
