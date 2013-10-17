package com.gmaslowski.ergast.url;

public class ConstructorsUrlBuilder extends AbstractErgastUrlBuilder<ConstructorsUrlBuilder> {

    private static final String CONSTRUCTORS = "constructors";

    private ConstructorsUrlBuilder(ErgastUrl ergastUrl) {
        this.ergastUrl = ergastUrl;
    }

    public static ConstructorsUrlBuilder constructorsBuilder(ErgastUrl ergastUrl) {
        return new ConstructorsUrlBuilder(ergastUrl);
    }


    ConstructorsUrlBuilder constructors() {
        ergastUrl.addUrlPart(CONSTRUCTORS);
        return this;
    }

    ConstructorsUrlBuilder constructors(String constructorId) {
        ergastUrl.addUrlPart(CONSTRUCTORS);
        ergastUrl.addUrlPart(constructorId);
        return this;
    }

    @Override
    protected ConstructorsUrlBuilder getConcreteBuilder() {
        return this;
    }
}
