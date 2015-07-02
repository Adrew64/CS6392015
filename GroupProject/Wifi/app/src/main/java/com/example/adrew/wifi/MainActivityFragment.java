package com.example.adrew.wifi;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    //ccode
    private ListView myListView;
    private String[] strListView;


    //TEST!
    final String[] items = new String[] { "Starbucks", "Leo's Pizza", "Bus Wifi"  };


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView list = (ListView)view.findViewById(R.id.myListView);
        CustomAdapter cus = new CustomAdapter(getActivity(),items);
        list.setAdapter(cus);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                Log.v("TAG", "Are you sure you want to connect?: " + arg2);

                Intent myIntent = new Intent(getActivity(), MainActivityFragment.class);
                myIntent.putExtra("welkerij", arg2);
                startActivity(myIntent);

            }

        });

        return view;

    }

}
