package com.example.reto1_g35.vista.favorites;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.reto1_g35.R;
import com.example.reto1_g35.modelo.ConsultarApi;
import com.example.reto1_g35.modelo.favoritos.AdaptadorFavoritos;
import com.example.reto1_g35.modelo.favoritos.EntidadFavoritos;
import com.example.reto1_g35.vista.productos.ProductosFragment;

import java.util.ArrayList;


public class FavoritesFragment extends Fragment {


    GridView listViewProd;
    ArrayList<EntidadFavoritos> listaProductos;
    ConsultarApi consultarApi;

    public FavoritesFragment() {
        // Required empty public constructor
    }


    public static void actualizarFavoritos(EntidadFavoritos item, Context context) {

        if (item.getFavoritos() == 0) {
            ProductosFragment.enviarRequest(1, item.getTitulo(), context);
            item.setFavoritos(1);
        } else {
            item.setFavoritos(0);
            ProductosFragment.enviarRequest(0, item.getTitulo(), context);
        }

        return;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        consultarApi = new ConsultarApi();
        // Inflate the layout for this fragment
        View view1 = inflater.inflate(R.layout.fragment_favoritest, container, false);
        //--------------------------------------------------------------------------------
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(view1.getContext());
           consultarApi.getProdItems(requestQueue);
            listViewProd = (GridView) view1.findViewById(R.id.viewFavoritos);
            AdaptadorFavoritos adaptadorFavorites = new AdaptadorFavoritos(ConsultarApi.listaProductos, view1.getContext());
            listViewProd.setAdapter(adaptadorFavorites);
        } catch (Exception e) {
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
        }


        //tituloFragment = (TextView) view.findViewById(R.id.resumenFavoritos);
        //-----------------------------------------------------------------------------
        return view1;
    }


}