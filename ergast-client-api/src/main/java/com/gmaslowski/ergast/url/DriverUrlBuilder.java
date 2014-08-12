package com.gmaslowski.ergast.url;

import static com.google.common.base.Preconditions.checkNotNull;

public class DriverUrlBuilder {

    private static final String SLASH = "/";
    private static final String GRID_PATH = "grid";
    private static final String DRIVERS_PATH = "drivers";
    private static final String CONSTRUCTORS_PATH = "constructors";
    private static final String CIRCUITS_PATH = "circuits";
    private static final String RESULT_PATH = "results";
    private static final String STATUS_PATH = "status";
    private static final String FASTEST_RANK_PATH = "fastest";

    // driver specific
    private String name;

    // all specific
    private int year;
    private String constructor;
    private String circuitId;
    private boolean currentYear = false;
    private int gridPosition;
    private int finishingPosition;
    private String statusId;
    private String CURRENT_YEAR = "current";
    private int fastestRank;

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

    public DriverUrlBuilder currentYear() {
        this.currentYear = true;
        return this;
    }

    public DriverUrlBuilder drivingInYear(int year) {
        this.year = year;
        return this;
    }

    public DriverUrlBuilder drivingOnCircuit(String circuitId) {
        this.circuitId = circuitId;
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
        } else if (currentYear) {
            builder.append(SLASH + CURRENT_YEAR);
        }

        if (constructor != null) {
            builder.append(SLASH + CONSTRUCTORS_PATH + SLASH + constructor);
        }

        if (circuitId != null) {
            builder.append(SLASH + CIRCUITS_PATH + SLASH + circuitId);
        }

        if (gridPosition != 0) {
            builder.append(SLASH + GRID_PATH + SLASH + gridPosition);
        }

        if (finishingPosition != 0) {
            builder.append(SLASH + RESULT_PATH + SLASH + finishingPosition);
        }

        if (statusId != null) {
            builder.append(SLASH + STATUS_PATH + SLASH + statusId);
        }

        if (fastestRank != 0) {
            builder.append(SLASH + FASTEST_RANK_PATH + SLASH + fastestRank);
        }

        builder.append(SLASH + DRIVERS_PATH);

        if (name != null) {
            builder.append(SLASH + name);
        }

        return builder.toString();
    }

    public DriverUrlBuilder drivingOnGrid(int gridPosition) {
        this.gridPosition = gridPosition;
        return this;
    }

    public DriverUrlBuilder finishedOnPosition(int finishingPosition) {
        this.finishingPosition = finishingPosition;
        return this;
    }

    public DriverUrlBuilder withStatus(String someStatus) {
        this.statusId = someStatus;
        return this;
    }

    public DriverUrlBuilder withFastest(int fastestRank) {
        this.fastestRank = fastestRank;
        return this;
    }
}
