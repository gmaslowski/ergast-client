package com.gmaslowski.ergast.payload;

public interface ValueReturningPayloadTypeVisitor<TYPE> {
    TYPE visitJson();
}
