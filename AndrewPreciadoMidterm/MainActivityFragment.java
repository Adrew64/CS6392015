package com.example.adrew.midterm_final;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;




/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {



    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    public void onClick(View a){
        if(a.getId() == R.id.calculate){
            EditText text1=(EditText)findViewById(R.id.text1);
            EditText text2=(EditText)findViewById(R.id.text2);

            double num1;

            num1 = Double.parseDouble(text1.getText().toString());


            double answer= (num1 * 1.6);

            TextView t = (TextView)findViewById(R.id.text2);
            t.setText(""+answer);
        }
    }




};
