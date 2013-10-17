package com.gmaslowski.ergast;

import com.gmaslowski.ergast.entity.EGResponse;
import com.gmaslowski.ergast.payload.PayloadType;
import com.gmaslowski.ergast.payload.converter.PayloadConverter;
import com.gmaslowski.ergast.payload.converter.PayloadConverterFactory;
import com.gmaslowski.ergast.payload.request.PayloadRequester;
import com.gmaslowski.ergast.payload.request.basic.BasicRequester;
import com.gmaslowski.ergast.payload.url.modifier.PayloadTypeUrlModifierFactory;
import com.gmaslowski.ergast.url.ErgastUrl;
import com.gmaslowski.ergast.payload.url.modifier.PayloadTypeUrlModifier;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static com.gmaslowski.ergast.payload.PayloadType.JSON;

public class Ergast {

    private static final PayloadType DEFAULT_PAYLOAD_TYPE = JSON;

    private final PayloadType payloadType;

    private Ergast(PayloadType payloadType) {
        this.payloadType = payloadType;
    }

    public static final Ergast defaultInstance() {
        return new Ergast(DEFAULT_PAYLOAD_TYPE);
    }

    public EGResponse request(ErgastUrl ergastUrl) {

        // url modifier
        PayloadTypeUrlModifier urlModifier = payloadType.accept(new PayloadTypeUrlModifierFactory());
        URL url = ergastUrl.url(urlModifier);

        // requester
        PayloadRequester requester = new BasicRequester();
        InputStream inputStream = requester.request(url);

        // converter
        PayloadConverter converter = payloadType.accept(new PayloadConverterFactory());
        return converter.convert(inputStream);
    }
}


