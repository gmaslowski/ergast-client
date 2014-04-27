package com.gmaslowski.ergast.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.rules.ExpectedException.none;
import static org.mockito.MockitoAnnotations.initMocks;

public class AbstractUnitTest {

    @Rule
    public ExpectedException expectedException = none();

    @Before
    public void mocks() {
        initMocks(this);
    }


}
