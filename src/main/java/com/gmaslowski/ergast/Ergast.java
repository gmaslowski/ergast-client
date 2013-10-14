package com.gmaslowski.ergast;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.gmaslowski.ergast.url.ErgastUrlBuilder.DEFAULT_ERGAST_URL;

public class Ergast {

    public EGResponse getDriver(String driverId) throws IOException {

        URL url = new URL(DEFAULT_ERGAST_URL + "/drivers/alonso.json");
        HttpURLConnection uc = (HttpURLConnection) url.openConnection();
        uc.setRequestMethod("GET");
        InputStream inputStream = uc.getInputStream();
        Gson gson = new Gson();

        JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
        EGResponse o  = gson.fromJson(reader, EGResponse.class);
        reader.close();

        return o;
    }
}


