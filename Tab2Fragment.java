package com.example.valcar3d.fragmenttabs.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.valcar3d.fragmenttabs.R;
import com.example.valcar3d.fragmenttabs.RecyclerView.CustomAdapter;

/**
 * Created by Valcar3D on 10/12/2017.
 */

public class Tab2Fragment extends Fragment implements CustomAdapter.ListItemClickListener
{
    private static final int NUM_LIST_ITEMS = 100;
    private Adapter mAdapter;
    private RecyclerView mNumbersList;
    private Toast mToast;

    Button btnTest; //codigo boton por default

//Codigo por default de un boton con su toast
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.tab1_fragment, container, false);
        btnTest =(Button) view.findViewById(R.id.rv_numbers);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this); //AQUI TENGO ERROR 
        mNumbersList.setLayoutManager(layoutManager);

        mNumbersList.setHasFixedSize(true);

        mAdapter = (Adapter) new CustomAdapter(NUM_LIST_ITEMS, this);
        mNumbersList.setAdapter((RecyclerView.Adapter) mAdapter);

        btnTest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getActivity(), "Testing button click 1", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
    //Final codigo por default de un boton con su toast


    @Override
    public void onListItemClick(int clickedItemIndex) {
        if (mToast != null)
        {
            mToast.cancel();
        }

        String toastMessage = "Item #" + clickedItemIndex + " clicked.";
        mToast = Toast.makeText(getActivity(), toastMessage, Toast.LENGTH_LONG);

        mToast.show();
    }
}
