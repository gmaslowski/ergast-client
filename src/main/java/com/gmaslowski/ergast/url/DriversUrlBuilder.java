package com.gmaslowski.ergast.url;

import java.util.List;

import static com.gmaslowski.ergast.url.SeasonsUrlBuilder.seasonsBuilder;

public class DriversUrlBuilder extends AbstractErgastUrlBuilder {

    private static final String DRIVERS = "drivers";

    private DriversUrlBuilder(List<String> ergastUrlParts) {
        this.ergastUrlParts = ergastUrlParts;
    }

    static DriversUrlBuilder driversBuilder(List<String> ergastUrlParts) {
        return new DriversUrlBuilder(ergastUrlParts);
    }

    public DriversUrlBuilder drivers() {
        ergastUrlParts.add(DRIVERS);
        return this;
    }

    public DriversUrlBuilder drivers(String driverId) {
        ergastUrlParts.add(DRIVERS);
        ergastUrlParts.add(driverId);
        return this;
    }

    public SeasonsUrlBuilder seasons() {
        return seasonsBuilder(ergastUrlParts).seasons();
    }

}
