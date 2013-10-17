package com.gmaslowski.ergast.url;

import com.google.common.annotations.VisibleForTesting;

import java.util.List;

import static com.google.common.base.Joiner.on;
import static com.google.common.base.Objects.toStringHelper;
import static com.google.common.collect.Lists.newArrayList;

public class ErgastUrl {

    @VisibleForTesting
    static final Integer DEFAULT_LIMIT = 30;
    @VisibleForTesting
    static final Integer DEFAULT_OFFSET = 0;

    private List<String> parts = newArrayList();
    private String limit;
    private String offset;


    public void addUrlPart(String part) {
        parts.add(part);
    }

    public void limit(Integer limit) {
        this.limit = limit.toString();
    }

    public void offset(Integer offset) {
        this.offset = offset.toString();
    }

    public String url() {
        String url = on("/").join(parts);

        return offsetAndLimit(url);
    }

    private String offsetAndLimit(String url) {
        if (limit != null || offset != null) {
            url = url.concat(String.format("?limit=%s&offset=%s", evaluateLimit(), evaluateOffset()));
        }
        return url;
    }

    private String evaluateLimit() {
        return limit != null ? limit : DEFAULT_LIMIT.toString();
    }

    private String evaluateOffset() {
        return offset != null ? offset : DEFAULT_OFFSET.toString();
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("urlParts", parts)
                .add("limit", limit)
                .add("offset", offset)
                .toString();
    }
}