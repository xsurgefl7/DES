package com.example.project2;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    String encryption;
    String decryption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DES cipher = new DES();

        EditText message = (EditText) findViewById(R.id.editText1);
        EditText key = (EditText) findViewById(R.id.editText2);
        Button encryptB = (Button) findViewById(R.id.button);
        Button decryptB = (Button) findViewById(R.id.button2);
        TextView convertedEn = findViewById(R.id.textView2);
        TextView convertedDe = findViewById(R.id.textView3);

        String sameMessage = message.getText().toString();
        String sameKey = key.getText().toString();

        encryptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                encryption = cipher.encrypt(sameMessage, sameKey);
                convertedEn.setText(encryption);
            }
        });

        decryptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decryption = cipher.decrypt(sameMessage, sameKey);
                convertedDe.setText(decryption);
            }
        });

    }

}