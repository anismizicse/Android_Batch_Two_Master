package com.ourdreamit.batch002class02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if(getIntent().hasExtra("Email") || getIntent().hasExtra("Password")) {

            String email = getIntent().getStringExtra("Email");
            String password = getIntent().getStringExtra("Password");

            if (email.length() == 10) {
                Toast.makeText(this, "Email is 10 Characters long", Toast.LENGTH_SHORT).show();
            }

            Toast.makeText(this, email + " " + password, Toast.LENGTH_SHORT).show();
        }
    }
}
