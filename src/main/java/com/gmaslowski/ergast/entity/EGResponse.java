package com.gmaslowski.ergast.entity;

import com.google.gson.annotations.SerializedName;

import static com.google.common.base.Objects.toStringHelper;

public class EGResponse {

    @SerializedName("MRData")
    private EGMRData mrdata;

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("mrdata", mrdata)
                .toString();
    }
}