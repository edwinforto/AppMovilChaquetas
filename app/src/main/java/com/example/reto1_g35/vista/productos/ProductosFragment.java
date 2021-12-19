package com.example.reto1_g35.vista.productos;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.reto1_g35.R;
import com.example.reto1_g35.modelo.ConsultarApi;
import com.example.reto1_g35.modelo.favoritos.EntidadFavoritos;
import com.example.reto1_g35.modelo.producto.AdaptadorProducto;
import com.example.reto1_g35.modelo.producto.EntidadProducto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ProductosFragment extends Fragment {


    public static int[] listImg = {R.drawable.catalogohombre3, R.drawable.catalogohombre2, R.drawable.catalogmujer3,
            R.drawable.catalogninos1, R.drawable.catalogmujer2};


    private ListView listViewProd;
    private AdaptadorProducto adaptadorProducto;
    ConsultarApi consultarApi;

    public ProductosFragment() {
        // Required empty public constructor
    }

    public static void actualizarFavoritos(EntidadProducto item, Context activity) {

        System.out.println("here1--> " + item.getFavoritos());
        if (item.getFavoritos() == 1) {
            System.out.println("here2");
            enviarRequest(1, item.getTitulo(), activity);
            item.setFavoritos(1);
        } else {
            item.setFavoritos(0);
            enviarRequest(0, item.getTitulo(), activity);
        }
        return;
    }

    public static void enviarRequest(int isFavorito, String titulo, Context context) {
        RequestQueue MyRequestQueue = Volley.newRequestQueue(context);
        String url = "https://gc6b27684ca8ed5-usaciclo4.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/api/chaquetas/admin/:isFavoritos/:titulo";
        url = url.replace(":isFavoritos", Integer.toString(isFavorito)).replace(":titulo", titulo);// <----enter your post url here
        StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //This code is executed if the server responds, whether or not the response contains data.
                //The String 'response' contains the server's response.
            }
        }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
            @Override
            public void onErrorResponse(VolleyError error) {
                //This code is executed if there is an error.
            }
        });
        MyRequestQueue.add(MyStringRequest);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_productos, container, false);
        RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());
        ConsultarApi.todosLosProductos(requestQueue);
        //--------------------------------------------------------------------------------
        listViewProd = (ListView) view.findViewById(R.id.viewProducts);
        adaptadorProducto = new AdaptadorProducto(ConsultarApi.listaTodosProductos, getContext());
        listViewProd.setAdapter(adaptadorProducto);
        //tituloFragment = (TextView) view.findViewById(R.id.productosTitulo);
        //-----------------------------------------------------------------------------
        return view;
    }



}