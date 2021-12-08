package com.example.aplicacionchaqueta.Modelo.Servicios;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AdaptadorServicio extends BaseAdapter {

    private ArrayList<EntidadServicio> listaServ;
    private Context context;

    public AdaptadorServicio(ArrayList<EntidadServicio> listaServ, Context context) {
        this.listaServ = listaServ;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaServ.size();
    }

    @Override
    public Object getItem(int pos) {
        return listaServ.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        //view = LayoutInflater.from(context).inflate(R)
        return view;
    }
}
