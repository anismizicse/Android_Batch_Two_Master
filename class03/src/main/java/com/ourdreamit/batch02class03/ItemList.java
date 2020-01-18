package com.ourdreamit.batch02class03;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemList extends Fragment {

    Button details_a, details_b;
    Communicator communicator;

    public ItemList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        communicator = (Communicator) getActivity();

        details_a = view.findViewById(R.id.details_a);
        details_b = view.findViewById(R.id.details_b);

        details_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                communicator.buttonClicked(0);
            }
        });

        details_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                communicator.buttonClicked(1);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
