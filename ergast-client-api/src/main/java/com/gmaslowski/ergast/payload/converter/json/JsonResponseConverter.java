package com.gmaslowski.ergast.payload.converter.json;

import com.gmaslowski.ergast.entity.baredata.EGResponse;
import com.gmaslowski.ergast.payload.converter.PayloadConverter;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonResponseConverter implements PayloadConverter {

    @Override
    public EGResponse convert(InputStream stream) {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(stream));
        EGResponse egResponse = gson.fromJson(reader, EGResponse.class);
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return egResponse;
    }
}
