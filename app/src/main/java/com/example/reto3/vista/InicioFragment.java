package com.example.reto3.vista;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reto3.R;

public class InicioFragment extends Fragment{
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_inicio, container, false);
        //-----------------------------------------------------------------------------


        //-----------------------------------------------------------------------------
        return v;
    }
}
