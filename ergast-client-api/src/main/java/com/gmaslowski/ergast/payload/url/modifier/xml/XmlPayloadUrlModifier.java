package com.gmaslowski.ergast.payload.url.modifier.xml;

import com.gmaslowski.ergast.payload.url.modifier.PayloadTypeUrlModifier;

public class XmlPayloadUrlModifier implements PayloadTypeUrlModifier {

    @Override
    public String modify(String url) {
        return url.concat(".xml");
    }
}
