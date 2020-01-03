package com.ourdreamit.batch002introclass_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private  int data = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_relative);
        Log.d(TAG, "onCreate: ");

        if(savedInstanceState == null){
            Toast.makeText(this, "Nothing Saved", Toast.LENGTH_SHORT).show();
        }else{
            int previousData = savedInstanceState.getInt("Data");
            Toast.makeText(this, "Previous Data = "+previousData, Toast.LENGTH_SHORT).show();
            data = previousData;
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("Data",data);
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
    }



    public void loginClicked(View view){

        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("New AlertDialog");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "OK clicked", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "No Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);*/
        data++;
        Toast.makeText(this, data+"", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
