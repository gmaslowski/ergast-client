package com.gmaslowski.ergast.url;

abstract class AbstractErgastUrlBuilder<BUILDER extends AbstractErgastUrlBuilder> {

    protected BUILDER concreteBuilder = getConcreteBuilder();
    protected ErgastUrl ergastUrl;

    public BUILDER limit(Integer limit) {
        ergastUrl.limit(limit);
        return concreteBuilder;
    }

    public BUILDER offset(Integer offset) {
        ergastUrl.offset(offset);
        return concreteBuilder;
    }

    public String url() {
        return ergastUrl.url().concat(".json");
    }

    protected abstract BUILDER getConcreteBuilder();

}
