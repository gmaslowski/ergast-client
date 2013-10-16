package com.gmaslowski.ergast;

import org.junit.Test;

import java.io.IOException;

public class ErgastTest {


    @Test
    public void shouldGetDriver() throws IOException {
        Ergast ergast = new Ergast();
        EGResponse o = null;

        o = ergast.getDriver("id");

        System.out.println(o);

    }

}
