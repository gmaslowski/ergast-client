package com.gmaslowski.ergast.payload.url.modifier;

import com.gmaslowski.ergast.payload.ValueReturningPayloadTypeVisitor;
import com.gmaslowski.ergast.payload.url.modifier.json.JsonPayloadUrlModifier;

public class PayloadTypeUrlModifierFactory implements ValueReturningPayloadTypeVisitor<PayloadTypeUrlModifier> {

    @Override
    public PayloadTypeUrlModifier visitJson() {
        return new JsonPayloadUrlModifier();
    }
}
