package com.gmaslowski.ergast.url.builder;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public abstract class UrlBuilderTemplate {

    protected static final String SLASH = "/";

    protected static final String DRIVER_PATH = "drivers";
    protected static final String DRIVER_STANDINGS_PATH = "driverStandings";
    protected static final String CONSTRUCTOR_STANDINGS_PATH = "constructorStandings";
    protected static final String GRID_PATH = "grid";
    protected static final String CONSTRUCTORS_PATH = "constructors";
    protected static final String CIRCUITS_PATH = "circuits";
    protected static final String RESULT_PATH = "results";
    protected static final String STATUS_PATH = "status";
    protected static final String FASTEST_RANK_PATH = "fastest";
    protected static final String YEAR = "current";

    private Map<String, String> urlParts = newHashMap();

    public UrlBuilderTemplate currentYear() {
        urlParts.put(YEAR, YEAR);
        return this;
    }

    public UrlBuilderTemplate inYear(int year) {
        urlParts.put(YEAR, String.valueOf(year));
        return this;
    }


    public UrlBuilderTemplate onCircuit(String circuitId) {
        urlParts.put(CIRCUITS_PATH, circuitId);
        return this;
    }

    public UrlBuilderTemplate byDriver(String driver) {
        urlParts.put(DRIVER_PATH, driver);
        return this;
    }

    public UrlBuilderTemplate byConstructor(String constructor) {
        urlParts.put(CONSTRUCTORS_PATH, constructor);
        return this;
    }

    public UrlBuilderTemplate onGrid(int gridPosition) {
        urlParts.put(GRID_PATH, String.valueOf(gridPosition));
        return this;
    }

    public UrlBuilderTemplate onPosition(int finishingPosition) {
        urlParts.put(RESULT_PATH, String.valueOf(finishingPosition));
        return this;
    }

    public UrlBuilderTemplate withStatus(String someStatus) {
        urlParts.put(STATUS_PATH, someStatus);
        return this;
    }

    public UrlBuilderTemplate withFastest(int fastestRank) {
        urlParts.put(FASTEST_RANK_PATH, String.valueOf(fastestRank));
        return this;
    }

    public String path() {
        StringBuilder builder = new StringBuilder();

        if (urlParts.containsKey(YEAR)) {
            builder.append(SLASH + urlParts.get(YEAR));
        }

        urlParts.entrySet().stream()
                .filter(urlPart -> !YEAR.equals(urlPart.getKey()))
                .forEach(urlPart -> builder.append(SLASH + urlPart.getKey() + SLASH + urlPart.getValue()));

        builder.append(buildUrlEnding());

        return builder.toString();
    }

    protected abstract String buildUrlEnding();
}
