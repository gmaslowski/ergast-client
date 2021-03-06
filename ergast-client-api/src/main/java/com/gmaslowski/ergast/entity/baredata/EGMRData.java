package com.gmaslowski.ergast.entity.baredata;

import static com.google.common.base.Objects.toStringHelper;

public class EGMRData {

    private String xmlns;
    private String series;
    private String url;
    private String limit;
    private String offset;
    private String total;

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("url", url)
                .add("limit", limit)
                .add("offset", offset)
                .add("total", total)
                .toString();
    }
}
