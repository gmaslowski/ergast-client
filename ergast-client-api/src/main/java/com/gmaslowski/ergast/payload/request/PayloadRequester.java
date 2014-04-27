package com.gmaslowski.ergast.payload.request;

import java.io.InputStream;
import java.net.URL;

public interface PayloadRequester {

    InputStream request(URL url);

}
