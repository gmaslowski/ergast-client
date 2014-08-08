package com.gmaslowski.ergast.url;

import static com.google.common.base.Preconditions.checkNotNull;

public class DriverUrlBuilder {

    private static final String SLASH = "/";

    private String name;
    private int year;

    private String DRIVERS_PATH = "drivers";
    private String CONSTRUCTORS_PATH = "constructors";

    private String constructor;

    private DriverUrlBuilder() {
    }

    private DriverUrlBuilder(String name) {
        this.name = name;
    }

    public static DriverUrlBuilder driver() {
        return new DriverUrlBuilder();
    }

    public static DriverUrlBuilder driver(String name) {
        return new DriverUrlBuilder(checkNotNull(name));
    }

    public DriverUrlBuilder drivingInYear(int year) {
        this.year = year;
        return this;
    }

    public DriverUrlBuilder drivingForConstructor(String constructor) {
        this.constructor = constructor;
        return this;
    }

    public String path() {
        StringBuilder builder = new StringBuilder();

        if (year != 0) {
            builder.append(SLASH + year);
        }

        if (constructor != null) {
            builder.append(SLASH + CONSTRUCTORS_PATH + SLASH + constructor);
        }

        builder.append(SLASH + DRIVERS_PATH);

        if (name != null) {
            builder.append(SLASH + name);
        }

        return builder.toString();
    }
}
