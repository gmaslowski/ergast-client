package com.gmaslowski.ergast.payload.request.basic;

import static java.util.concurrent.TimeUnit.SECONDS;
import com.gmaslowski.ergast.payload.request.PayloadRequester;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BasicPayloadRequester implements PayloadRequester {

    private static final int DEFAULT_READ_TIMEOUT = (int) SECONDS.toMillis(15L);
    private static final int DEFAULT_CONNECTION_TIMEOUT = (int) SECONDS.toMillis(15L);

    public static BasicPayloadRequester basicPayloadRequester() {
        return new BasicPayloadRequester(DEFAULT_CONNECTION_TIMEOUT, DEFAULT_READ_TIMEOUT);
    }

    public static BasicPayloadRequester basicPayloadRequester(int connectionTimeout, int readTimeout) {
        return new BasicPayloadRequester(connectionTimeout, readTimeout);
    }

    private BasicPayloadRequester(int connectionTimeout, int readTimeout) {
        this.readTimeout = readTimeout;
        this.connectionTimeout = connectionTimeout;
    }

    private final int readTimeout;
    private final int connectionTimeout;

    @Override
    public InputStream request(URL url) {
        HttpURLConnection uc = null;
        try {
            uc = (HttpURLConnection) url.openConnection();
            uc.setRequestMethod("GET");
            uc.setConnectTimeout(connectionTimeout);
            uc.setReadTimeout(readTimeout);

            return uc.getInputStream();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
