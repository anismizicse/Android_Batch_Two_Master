package com.ourdreamit.batch02class03;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements Communicator {

    String email, pass;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    RelativeLayout list_item_container;
    ArrayList<NewsDetails> list = new ArrayList<>();

    int orientation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        NewsDetails news1 = new NewsDetails("News 1", "Masum is feeling bored. Want's to go home.");
        NewsDetails news2 = new NewsDetails("News 2", "Anis is going to be mad very soon");

        list.add(news1);
        list.add(news2);

        email = getIntent().getStringExtra("Email Data");
        pass = getIntent().getStringExtra("Pass Data");


        list_item_container = findViewById(R.id.list_item_container);

        Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, pass, Toast.LENGTH_SHORT).show();


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        /*try {
            fragmentTransaction.remove(fragmentManager.findFragmentByTag("ItemList"));
            fragmentTransaction.remove(fragmentManager.findFragmentByTag("Details"));
        } catch (Exception e) {

        }*/


        orientation = this.getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {

            ViewGroup.LayoutParams params = list_item_container.getLayoutParams();
            params.width = this.getResources().getDisplayMetrics().widthPixels;
            list_item_container.setLayoutParams(params);

            Toast.makeText(this, "Portrait Mode", Toast.LENGTH_SHORT).show();

            fragmentTransaction.replace(R.id.list_item_container, new ItemList(), "ItemList");

        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "LandScape Mode", Toast.LENGTH_SHORT).show();
            fragmentTransaction.replace(R.id.list_item_container, new ItemList(), "ItemList");
            fragmentTransaction.replace(R.id.details_container, new DetailsFragment("", ""), "Details");
        }


        fragmentTransaction.commit();


    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "Portrait Mode", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "LandScape Mode", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void buttonClicked(int position) {

        NewsDetails newsDetails = list.get(position);

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("title",newsDetails.title);
            intent.putExtra("details",newsDetails.details);
            startActivity(intent);
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.details_container, new DetailsFragment(newsDetails.title, newsDetails.details), "Details");
            fragmentTransaction.commit();
        }
    }
}
