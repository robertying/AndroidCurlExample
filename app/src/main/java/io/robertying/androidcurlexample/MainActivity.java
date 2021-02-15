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

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = this;
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        System.loadLibrary("curl-a-website");

        CA_BUNDLE = CurlHelper.getCaBundlePath(this);

        button.setOnClickListener(new View.OnClickListener() {
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
    }

}
