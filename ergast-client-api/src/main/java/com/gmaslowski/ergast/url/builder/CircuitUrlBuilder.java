package com.gmaslowski.ergast.url.builder;

import static com.google.common.base.Preconditions.checkNotNull;

public class CircuitUrlBuilder extends UrlBuilderTemplate {

	private String name;

	private CircuitUrlBuilder() {
	}

	private CircuitUrlBuilder(String name) {
		this.name = name;
	}

	public static UrlBuilderTemplate circuit() {
		return new CircuitUrlBuilder();
	}

	public static UrlBuilderTemplate circuit(String name) {
		return new CircuitUrlBuilder(checkNotNull(name));
	}

	@Override
	public String buildUrlEnding() {
		if (name == null) {
			return SLASH + CIRCUITS_PATH;
		}

		return SLASH + CIRCUITS_PATH + SLASH + name;
	}
}
