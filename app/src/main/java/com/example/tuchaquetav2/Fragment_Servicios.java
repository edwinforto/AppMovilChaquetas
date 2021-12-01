package com.example.tuchaquetav2;

/**
 *
 *
 * @author Denisse Rincón
 */

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Fragment_Servicios extends Fragment {

    Drawable drawable1, drawable2, drawable3;
    ImageView imagen4, imagen5, imagen6;

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__servicios, container, false);
        //-----------------------------------------------------------------------------


        //-------------------------------- CARGUE DE IMAGENES ------------------------------

        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.s1, v.getContext().getTheme());

        imagen4 = (ImageView)v.findViewById(R.id.imagen4);
        imagen4.setImageDrawable(drawable1);

        //--------------------------------------------------------

        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.s2, v.getContext().getTheme());

        imagen5= (ImageView) v.findViewById(R.id.imagen5);
        imagen5.setImageDrawable(drawable2);

        //--------------------------------------------------------

        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.s3, v.getContext().getTheme());

        imagen6= (ImageView) v.findViewById(R.id.imagen6);
        imagen6.setImageDrawable(drawable3);


        //-----------------------------------------------------------------------------
        return v;
    }
}