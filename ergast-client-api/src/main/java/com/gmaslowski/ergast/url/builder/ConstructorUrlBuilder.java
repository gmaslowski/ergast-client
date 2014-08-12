package com.gmaslowski.ergast.url.builder;

import static com.google.common.base.Preconditions.checkNotNull;

public class ConstructorUrlBuilder extends UrlBuilderTemplate {

    private ConstructorUrlBuilder(String name) {
        this.name = name;
    }

    public static UrlBuilderTemplate constructor() {
        return new ConstructorUrlBuilder();
    }

    public static UrlBuilderTemplate constructor(String name) {
        return new ConstructorUrlBuilder(checkNotNull(name));
    }

    private ConstructorUrlBuilder() {
    }

    private String name;

    @Override
    public String buildUrlEnding() {
        if (name == null) {
            return SLASH + CONSTRUCTORS_PATH;
        }

        return SLASH + CONSTRUCTORS_PATH + SLASH + name;
    }
}
