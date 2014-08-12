package com.gmaslowski.ergast.url.builder;

import static com.google.common.base.Preconditions.checkNotNull;

public class DriverUrlBuilder extends UrlBuilderTemplate {

    private String name;

    private DriverUrlBuilder() {
    }

    private DriverUrlBuilder(String name) {
        this.name = name;
    }

    public static UrlBuilderTemplate driver() {
        return new DriverUrlBuilder();
    }

    public static UrlBuilderTemplate driver(String name) {
        return new DriverUrlBuilder(checkNotNull(name));
    }

    @Override
    public String voila() {
        if (name == null) {
            return SLASH + DRIVER_PATH;
        }

        return SLASH + DRIVER_PATH + SLASH + name;
    }
}
