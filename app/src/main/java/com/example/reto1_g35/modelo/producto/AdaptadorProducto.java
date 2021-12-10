package com.example.reto1_g35.modelo.producto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reto1_g35.R;

import java.util.ArrayList;


public class AdaptadorProducto extends BaseAdapter {

    private ArrayList<EntidadProducto> listaProd;
    private Context context;

    public AdaptadorProducto(ArrayList<com.example.reto1_g35.modelo.producto.EntidadProducto> listaProd, Context context) {
        this.listaProd = listaProd;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaProd.size();
    }

    @Override
    public Object getItem(int pos) {
        return listaProd.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {

            com.example.reto1_g35.modelo.producto.EntidadProducto item = (com.example.reto1_g35.modelo.producto.EntidadProducto) getItem(pos);

        view = LayoutInflater.from(context).inflate(R.layout.item_producto, null);
        //------------------------------------------------------------------------
        ImageView img1 = (ImageView) view.findViewById(R.id.imagenItem);
        TextView titulo = (TextView) view.findViewById(R.id.nombreItem);
        TextView descripcion = (TextView) view.findViewById(R.id.descripcionItem);
        Button compra = (Button) view.findViewById(R.id.compra);
        CheckBox fav = (CheckBox) view.findViewById(R.id.fav);

        //-------------Enlazar elementos------------------------

        img1.setImageResource(item.getImagen());
        titulo.setText(item.getTitulo());
        descripcion.setText(item.getDescripcion());


        //------------------------------------------------------------------------
        return view;
    }
}