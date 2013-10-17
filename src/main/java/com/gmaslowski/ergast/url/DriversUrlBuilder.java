package com.gmaslowski.ergast.url;

import static com.gmaslowski.ergast.url.SeasonsUrlBuilder.seasonsBuilder;

public class DriversUrlBuilder extends AbstractErgastUrlBuilder<DriversUrlBuilder> {

    private static final String DRIVERS = "drivers";

    private DriversUrlBuilder(ErgastUrl ergastUrl) {
        this.ergastUrl = ergastUrl;
    }

    static DriversUrlBuilder driversBuilder(ErgastUrl ergastUrl) {
        return new DriversUrlBuilder(ergastUrl);
    }

    public DriversUrlBuilder drivers() {
        ergastUrl.addUrlPart(DRIVERS);
        return this;
    }

    public DriversUrlBuilder drivers(String driverId) {
        ergastUrl.addUrlPart(DRIVERS);
        ergastUrl.addUrlPart(driverId);
        return this;
    }

    public SeasonsUrlBuilder seasons() {
        return seasonsBuilder(ergastUrl).seasons();
    }

    @Override
    protected DriversUrlBuilder getConcreteBuilder() {
        return this;
    }
}
