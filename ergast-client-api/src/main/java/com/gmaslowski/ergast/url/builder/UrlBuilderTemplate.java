package com.gmaslowski.ergast.url.builder;

public abstract class UrlBuilderTemplate {

    protected static final String SLASH = "/";

    protected static final String DRIVER_PATH = "drivers";
    protected static final String GRID_PATH = "grid";
    protected static final String CONSTRUCTORS_PATH = "constructors";
    protected static final String CIRCUITS_PATH = "circuits";
    protected static final String RESULT_PATH = "results";
    protected static final String STATUS_PATH = "status";
    protected static final String FASTEST_RANK_PATH = "fastest";
    protected static final String CURRENT_YEAR = "current";

    // all specific
    private boolean currentYear = false;
    private int year;
    private int fastestRank;
    private int gridPosition;
    private int finishingPosition;
    private String constructor;
    private String circuitId;
    private String statusId;

    public UrlBuilderTemplate currentYear() {
        this.currentYear = true;
        return this;
    }

    public UrlBuilderTemplate inYear(int year) {
        this.year = year;
        return this;
    }

    public UrlBuilderTemplate onCircuit(String circuitId) {
        this.circuitId = circuitId;
        return this;
    }

    public UrlBuilderTemplate byConstructor(String constructor) {
        this.constructor = constructor;
        return this;
    }

    public UrlBuilderTemplate onGrid(int gridPosition) {
        this.gridPosition = gridPosition;
        return this;
    }

    public UrlBuilderTemplate onPosition(int finishingPosition) {
        this.finishingPosition = finishingPosition;
        return this;
    }

    public UrlBuilderTemplate withStatus(String someStatus) {
        this.statusId = someStatus;
        return this;
    }

    public UrlBuilderTemplate withFastest(int fastestRank) {
        this.fastestRank = fastestRank;
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

        builder.append(voila());

        return builder.toString();
    }

    public abstract String voila();
}
