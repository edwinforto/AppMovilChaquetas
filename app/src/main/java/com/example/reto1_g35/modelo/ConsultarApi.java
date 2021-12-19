package com.example.reto1_g35.modelo;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.reto1_g35.modelo.favoritos.EntidadFavoritos;
import com.example.reto1_g35.modelo.producto.EntidadProducto;
import com.example.reto1_g35.vista.productos.ProductosFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class ConsultarApi {

    public static ArrayList<EntidadFavoritos> listaProductos = new ArrayList<>();
    public static ArrayList<EntidadProducto> listaTodosProductos = new ArrayList<>();

    public static ArrayList<EntidadProducto> todosLosProductos( RequestQueue requestQueue) {
        ArrayList<EntidadProducto> listaProductos2 = new ArrayList<>();

        String url = "https://gc6b27684ca8ed5-usaciclo4.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/api/chaquetas/productos";




        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //***********************************************************
                try {

                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        int img = jsonObject.getInt("img");
                        String titulo = jsonObject.getString("titulo");
                        String descripcion = jsonObject.getString("descripcion");
                        String valor = jsonObject.getString("valor");
                        int isfavoritos = jsonObject.getInt("isfavoritos");

                        listaProductos2.add(new EntidadProducto(ProductosFragment.listImg[img], titulo, descripcion, valor, isfavoritos));


                    }
                    listaTodosProductos=listaProductos2;
                    //tituloFragment.setText("Productos"+'\n');
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //***********************************************************
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
        /* ================================================================================================== */

        return listaProductos2;


    }

    public ArrayList<EntidadFavoritos> getProdItems(RequestQueue requestQueue){
        ArrayList<EntidadFavoritos> listaProductos2 = new ArrayList<>();

        String url = "https://gc6b27684ca8ed5-usaciclo4.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/api/chaquetas/favoritos";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //***********************************************************
                if (response != null) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        int img = jsonObject.getInt("img");
                        String titulo = jsonObject.getString("titulo");
                        String descripcion = jsonObject.getString("descripcion");
                        String valor = jsonObject.getString("valor");
                        int isfavoritos = jsonObject.getInt("isfavoritos");

                        listaProductos2.add(new EntidadFavoritos(ProductosFragment.listImg[img], titulo, descripcion,valor,isfavoritos));
                    }
                    listaProductos=listaProductos2;
                    //tituloFragment.setText('\n');
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                }

                //***********************************************************
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
        /* ================================================================================================== */

        return listaProductos2;


    }


}