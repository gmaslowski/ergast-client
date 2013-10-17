package com.gmaslowski.ergast.payload;

public enum PayloadType {
    JSON {
        @Override
        public <TYPE> TYPE accept(ValueReturningPayloadTypeVisitor<TYPE> valueReturningPayloadTypeVisitor) {
            return valueReturningPayloadTypeVisitor.visitJson();
        }
    };

    public abstract <TYPE> TYPE accept(ValueReturningPayloadTypeVisitor<TYPE> valueReturningPayloadTypeVisitor);
}
