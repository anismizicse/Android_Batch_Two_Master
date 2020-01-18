package com.ourdreamit.batch02class03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RelativeLayout;

public class DetailsActivity extends AppCompatActivity {

    RelativeLayout fragment_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        fragment_container = findViewById(R.id.fragment_container);

        String title = getIntent().getStringExtra("title");
        String details = getIntent().getStringExtra("details");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new DetailsFragment(title, details));
        fragmentTransaction.commit();


    }
}
