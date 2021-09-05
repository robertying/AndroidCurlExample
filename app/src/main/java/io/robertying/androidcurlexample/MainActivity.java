package io.robertying.androidcurlexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String CA_BUNDLE;

    AppCompatActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = this;
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText);
        Button curlButton = findViewById(R.id.curl_button);
        Button versionButton = findViewById(R.id.version_button);

        System.loadLibrary("curl-a-website");

        CurlHelper.copyCaBundleFromAssetsToInternalStorage(this);
        CA_BUNDLE = CurlHelper.getCaBundlePath(this);

        curlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editText.getText().toString();
                boolean success = CurlHelper.curlAWebsite(CA_BUNDLE, url);

                if (success) {
                    Toast.makeText(activity, "Curl succeeded", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(activity, "Curl failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        versionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Curl version: " + CurlHelper.getCurlVersion(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
