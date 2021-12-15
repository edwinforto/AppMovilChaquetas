package com.example.reto3.vista.sucursales;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.reto3.R;

public class SucursalesFragment extends Fragment {

    private View view;

    public SucursalesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sucursales, container, false);
        //--------------------------------------------------------------------------------


        //--------------------------------------------------------------------------------

        return view;
    }
}