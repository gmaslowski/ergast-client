package com.gmaslowski.ergast.payload.request.basic;

import com.gmaslowski.ergast.payload.request.PayloadRequester;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BasicPayloadRequester implements PayloadRequester {

    @Override
    public InputStream request(URL url) {
        HttpURLConnection uc = null;
        try {
            uc = (HttpURLConnection) url.openConnection();
            uc.setRequestMethod("GET");
            return uc.getInputStream();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
