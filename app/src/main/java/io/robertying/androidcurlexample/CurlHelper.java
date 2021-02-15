package io.robertying.androidcurlexample;

import android.content.Context;
import android.util.Log;
import android.content.res.AssetManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CurlHelper {
    private static final String CA_BUNDLE_NAME = "cacert.pem";

    public native static boolean curlAWebsite(String caBundlePath, String url);

    public static void copyCaBundleFromAssetsToInternalStorage(Context context) {
        AssetManager assetManager = context.getApplicationContext().getAssets();
        InputStream in;
        OutputStream out;

        try {
            in = assetManager.open(CA_BUNDLE_NAME);
            File caFile = new File(context.getApplicationContext().getFilesDir(), CA_BUNDLE_NAME);
            out = new FileOutputStream(caFile, false);

            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }

            in.close();
            out.flush();
            out.close();
        } catch (Exception e) {
            Log.e("CurlHelper", e.getMessage());
        }

        Log.i("CurlHelper", "CA bundle copied to internal storage");
    }

    static String getCaBundlePath(Context context) {
        return new File(context.getApplicationContext().getFilesDir(), CA_BUNDLE_NAME).getAbsolutePath();
    }
}
