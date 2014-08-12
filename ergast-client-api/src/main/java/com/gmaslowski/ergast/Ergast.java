package com.gmaslowski.ergast;

import static com.gmaslowski.ergast.payload.PayloadType.JSON;
import static com.gmaslowski.ergast.payload.request.basic.BasicPayloadRequester.basicPayloadRequester;
import com.gmaslowski.ergast.entity.baredata.EGResponse;
import com.gmaslowski.ergast.payload.PayloadType;
import com.gmaslowski.ergast.payload.converter.PayloadConverter;
import com.gmaslowski.ergast.payload.converter.PayloadTypeVisitorConverterFactory;
import com.gmaslowski.ergast.payload.request.PayloadRequester;
import com.gmaslowski.ergast.payload.url.modifier.PayloadTypeUrlModifier;
import com.gmaslowski.ergast.payload.url.modifier.PayloadTypeVisitorUrlModifierFactory;
import com.gmaslowski.ergast.url.ErgastUrl;
import java.io.InputStream;
import java.net.URL;

public class Ergast {

    private static final PayloadType DEFAULT_PAYLOAD_TYPE = JSON;
    private static final PayloadRequester DEFAULT_PAYLOAD_REQUESTER = basicPayloadRequester();

    private final PayloadRequester payloadRequester;

    private final PayloadType payloadType;
    private final PayloadTypeVisitorUrlModifierFactory payloadTypeVisitorUrlModifierFactory;
    private final PayloadTypeVisitorConverterFactory payloadTypeVisitorConverterFactory;

    private Ergast(PayloadType payloadType, PayloadRequester payloadRequester) {
        this.payloadType = payloadType;
        this.payloadRequester = payloadRequester;

        this.payloadTypeVisitorUrlModifierFactory = new PayloadTypeVisitorUrlModifierFactory();
        this.payloadTypeVisitorConverterFactory = new PayloadTypeVisitorConverterFactory();
    }

    public static final Ergast ergast() {
        return new Ergast(DEFAULT_PAYLOAD_TYPE, DEFAULT_PAYLOAD_REQUESTER);
    }

    public static final Ergast ergast(PayloadType payloadType) {
        return new Ergast(payloadType, DEFAULT_PAYLOAD_REQUESTER);
    }

    public static final Ergast ergast(PayloadRequester payloadRequester) {
        return new Ergast(DEFAULT_PAYLOAD_TYPE, payloadRequester);
    }

    public static final Ergast ergast(PayloadType payloadType, PayloadRequester payloadRequester) {
        return new Ergast(payloadType, payloadRequester);
    }

    public EGResponse request(ErgastUrl ergastUrl) {

        // url modifier
        PayloadTypeUrlModifier urlModifier = payloadType.accept(payloadTypeVisitorUrlModifierFactory);
        URL url = ergastUrl.url(urlModifier);

        // requester
        InputStream inputStream = payloadRequester.request(url);

        // converter
        PayloadConverter converter = payloadType.accept(payloadTypeVisitorConverterFactory);
        return converter.convert(inputStream);
    }
}


