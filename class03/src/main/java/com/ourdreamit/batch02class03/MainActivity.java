package com.ourdreamit.batch02class03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String log = "Start";
    String emailAddress, password;
    EditText email, pass;

    Button button, save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            Toast.makeText(this, "Null", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Not Null", Toast.LENGTH_SHORT).show();
            emailAddress = savedInstanceState.getString("emaildata");
            password = savedInstanceState.getString("passldata");
        }

        Log.d(log, "onCreate");

        button = findViewById(R.id.button);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String lemail = email.getText().toString();
               String lpass = pass.getText().toString();

                if (lemail.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Email is empty", Toast.LENGTH_SHORT).show();
                }else if(lpass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Pass is empty", Toast.LENGTH_SHORT).show();

                }else {

                    emailAddress = lemail;
                    password = lpass;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lemail = email.getText().toString();
                String lpass = pass.getText().toString();

                if (lemail.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Email is empty", Toast.LENGTH_SHORT).show();
                }else if(lpass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Pass is empty", Toast.LENGTH_SHORT).show();

                }else {
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("Email Data",emailAddress);
                    intent.putExtra("Pass Data",password);
                    startActivity(intent);

                }

            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d(log, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(log,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(log,"onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(log,"onPause");

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("emaildata",emailAddress);
        outState.putString("passldata",password);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(log,"onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(log,"onDestroy");

    }
}

