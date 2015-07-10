package com.example.adrew.convertmidterm;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.view.View.OnClickListener;


public class MainActivityFragment extends Fragment {


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        final EditText editMiles = (EditText) rootView.findViewById(R.id.editMiles);

        final EditText editInches = (EditText) rootView.findViewById(R.id.editKm);

        Button buttonConvert = (Button) rootView.findViewById(R.id.buttonConvert);

            buttonConvert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                double miles = Double.valueOf( editMiles.getText().toString());

                double km = miles *  1.609 ;

                editInches.setText(String.valueOf(km));
            }
        });

        return rootView;
    }



}
