package com.gmaslowski.ergast.url;

import java.util.List;

import static com.google.common.base.Joiner.on;

class AbstractErgastUrlBuilder {

    protected List<String> ergastUrlParts;

    public String url() {
        return on("/").join(ergastUrlParts).concat(".json");
    }
}
