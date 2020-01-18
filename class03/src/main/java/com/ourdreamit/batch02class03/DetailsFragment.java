package com.ourdreamit.batch02class03;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailsFragment extends Fragment {

    TextView newsTitle, detailstext;
    String title, details;

    public DetailsFragment(){

    }

    DetailsFragment(String title, String details){
        this.title = title;
        this.details = details;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details, container, false);

        newsTitle = view.findViewById(R.id.newsTitle);
        detailstext = view.findViewById(R.id.detailstext);

        newsTitle.setText(title);
        detailstext.setText(details);

        return view;
    }
}
