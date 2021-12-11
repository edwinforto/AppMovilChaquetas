package com.example.aplicacionchaqueta.Modelo.Compra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.aplicacionchaqueta.R;

import java.util.ArrayList;

public class AdaptadorCompra extends BaseAdapter {

    private ArrayList<EntidadCompra> listaCompra;
    private Context context;


    public AdaptadorCompra(ArrayList<EntidadCompra> listaCompra, Context context) {
        this.listaCompra = listaCompra;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaCompra.size();
    }

    @Override
    public Object getItem(int pos) {
        return listaCompra.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
    }

    /**
     * Se ponen los enlaces correspondientes a cada item
     * @param pos
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        EntidadCompra item = (EntidadCompra) getItem(pos);
        view = LayoutInflater.from(context).inflate(R.layout.item_compra, null);
        //-------------------------------------------------------------------
        ImageView img1 = (ImageView) view.findViewById(R.id.imgBuy);
        TextView titulo = (TextView) view.findViewById(R.id.tituloComp);
        ImageButton borrar = (ImageButton) view.findViewById(R.id.delete);

        //

        //------------------- ENLAZAR ELEMENTOS -----------------------------
        img1.setImageResource(item.getImagen());
        titulo.setText(item.getTitulo());

        //-------------------- OBTENER DATOS -----------------------------



        return view;
    }
}
