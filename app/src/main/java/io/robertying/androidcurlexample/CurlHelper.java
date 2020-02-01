package io.robertying.androidcurlexample;

import android.content.Context;

import java.io.File;

public class CurlHelper {
    private static final String CA_BUNDLE_NAME = "cacert.pem";

    public native static void curlAWebsite(String caBundlePath, String url);

    public static String getCaBundlePath(Context context) {
        return new File(context.getApplicationContext().getFilesDir(), CA_BUNDLE_NAME).getAbsolutePath();
    }
}
