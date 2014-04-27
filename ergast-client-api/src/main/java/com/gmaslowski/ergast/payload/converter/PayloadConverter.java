package com.gmaslowski.ergast.payload.converter;

import com.gmaslowski.ergast.entity.EGResponse;

import java.io.InputStream;

public interface PayloadConverter {

    EGResponse convert(InputStream stream);

}
