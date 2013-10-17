package com.gmaslowski.ergast;

import com.google.gson.annotations.SerializedName;

import static com.google.common.base.Objects.toStringHelper;

public class EGResponse<T> {

    @SerializedName("MRData")
    private EGMRData<T> mrdata;

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("mrdata", mrdata)
                .toString();
    }
}