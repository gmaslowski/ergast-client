package com.gmaslowski.ergast.url;

import java.util.List;

public class ConstructorsUrlBuilder extends AbstractErgastUrlBuilder {

    private static final String CONSTRUCTORS = "constructors";

    private ConstructorsUrlBuilder(List<String> ergastUrlParts) {
        this.ergastUrlParts = ergastUrlParts;
    }

    public static ConstructorsUrlBuilder constructorsBuilder(List<String> ergastUrlParts) {
        return new ConstructorsUrlBuilder(ergastUrlParts);
    }


    ConstructorsUrlBuilder constructors() {
        ergastUrlParts.add(CONSTRUCTORS);
        return this;
    }

    ConstructorsUrlBuilder constructors(String constructorId) {
        ergastUrlParts.add(CONSTRUCTORS);
        ergastUrlParts.add(constructorId);
        return this;
    }
}
