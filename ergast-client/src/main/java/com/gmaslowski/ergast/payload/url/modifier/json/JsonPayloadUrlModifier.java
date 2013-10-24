package com.gmaslowski.ergast.payload.url.modifier.json;

import com.gmaslowski.ergast.payload.url.modifier.PayloadTypeUrlModifier;

public class JsonPayloadUrlModifier implements PayloadTypeUrlModifier {

    @Override
    public String modify(String url) {
        return url.concat(".json");
    }
}
