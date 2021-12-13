package com.example.reto2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class Fragment_Favoritos extends Fragment {

    private View view;

    public Fragment_Favoritos() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment__favoritos, container, false);
        //--------------------------------------------------------------------------------


        //--------------------------------------------------------------------------------

        return view;
    }
}