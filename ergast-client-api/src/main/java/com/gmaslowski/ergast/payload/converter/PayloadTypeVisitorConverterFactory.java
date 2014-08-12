package com.gmaslowski.ergast.payload.converter;

import com.gmaslowski.ergast.payload.ValueReturningPayloadTypeVisitor;
import com.gmaslowski.ergast.payload.converter.json.JsonResponseConverter;
import com.gmaslowski.ergast.payload.converter.xml.XmlResponseConverter;

public class PayloadTypeVisitorConverterFactory implements ValueReturningPayloadTypeVisitor<PayloadConverter> {

    @Override
    public PayloadConverter visitJson() {
        return new JsonResponseConverter();
    }

    @Override
    public PayloadConverter visitXml() {
        return new XmlResponseConverter();
    }
}
