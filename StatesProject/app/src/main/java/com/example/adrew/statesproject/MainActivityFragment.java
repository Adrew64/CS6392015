package com.example.adrew.statesproject;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import android.widget.AdapterView;
import android.widget.ListView;
import android.content.Intent;

import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    //ccode
    private ListView myListView;
    private String[] strListView;



    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //texas is number 43 and code
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        myListView= (ListView) rootView.findViewById(R.id.myListView);
        strListView=getResources().getStringArray(R.array.my_data_list);
        ArrayAdapter<String> objAdapter=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1, strListView);
        myListView.setAdapter(objAdapter);
        //old return rootView;

        //test
        ListView lv = (ListView) rootView.findViewById(R.id.myListView);
        lv.setAdapter(objAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position == 42)
                {
                    Intent mapIntent = new Intent(getActivity(), MapsActivity.class);
                    startActivity(mapIntent);
                }
            }
        });
        return rootView;
        //return inflater.inflate(R.layout.fragment_main, container, false);
    }
}//end of main class
