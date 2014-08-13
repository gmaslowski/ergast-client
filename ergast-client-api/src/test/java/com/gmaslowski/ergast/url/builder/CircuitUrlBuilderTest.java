package com.gmaslowski.ergast.url.builder;

import static com.gmaslowski.ergast.url.builder.CircuitUrlBuilder.circuit;
import static com.gmaslowski.ergast.url.testdata.CircuitTestData.MONZA;

public class CircuitUrlBuilderTest extends AbstractUrlBuilderTest {
	@Override
	String givenPath() {
		return circuit().path();
	}

	@Override
	String expectedPath() {
		return "/circuits";
	}

	@Override
	String givenPathWithValue() {
		return circuit(MONZA).path();
	}

	@Override
	String expectedPathWithValue() {
		return "/circuits/monza";
	}
}
