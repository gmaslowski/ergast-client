package com.gmaslowski.ergast.payload.url.modifier;

import com.gmaslowski.ergast.payload.ValueReturningPayloadTypeVisitor;
import com.gmaslowski.ergast.payload.url.modifier.json.JsonPayloadUrlModifier;
import com.gmaslowski.ergast.payload.url.modifier.xml.XmlPayloadUrlModifier;

public class PayloadTypeUrlModifierFactory implements ValueReturningPayloadTypeVisitor<PayloadTypeUrlModifier> {

    @Override
    public PayloadTypeUrlModifier visitJson() {
        return new JsonPayloadUrlModifier();
    }

    @Override
    public PayloadTypeUrlModifier visitXml() {
        return new XmlPayloadUrlModifier();
    }
}
