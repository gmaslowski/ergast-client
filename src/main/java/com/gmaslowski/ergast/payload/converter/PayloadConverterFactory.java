package com.gmaslowski.ergast.payload.converter;

import com.gmaslowski.ergast.payload.ValueReturningPayloadTypeVisitor;
import com.gmaslowski.ergast.payload.converter.json.JsonResponseConverter;

public class PayloadConverterFactory implements ValueReturningPayloadTypeVisitor<PayloadConverter> {

    @Override
    public PayloadConverter visitJson() {
        return new JsonResponseConverter();
    }
}
