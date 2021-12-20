package com.example.reto1_g35.modelo.favoritos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reto1_g35.R;
import com.example.reto1_g35.vista.favorites.FavoritesFragment;

import java.util.ArrayList;


public class AdaptadorFavoritos extends BaseAdapter {

    private final ArrayList<EntidadFavoritos> listaProd;
    private final Context context;

    public AdaptadorFavoritos(ArrayList<EntidadFavoritos> listaProd, Context context) {
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

        EntidadFavoritos item = (EntidadFavoritos) getItem(pos);

        view = LayoutInflater.from(context).inflate(R.layout.item_producto, null);
        //------------------------------------------------------------------------
        ImageView img1 = view.findViewById(R.id.imagenItem);
        TextView titulo = view.findViewById(R.id.nombreItem);
        TextView descripcion = view.findViewById(R.id.descripcionItem);
        TextView valor = view.findViewById(R.id.valorItem);
        Button compra = (Button) view.findViewById(R.id.comprar);
        ImageButton fav = view.findViewById(R.id.imageFav);


        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavoritesFragment.actualizarFavoritos(item, context);
        /*System.out.println("view--> "+view);
        Cursor cursor= ProductosFragment.actualizarFavoritos(item, context);
        if (cursor.getString(4).equals("TRUE")){
            fav.setBackgroundResource(R.drawable.favorite);
            Toast.makeText(context, "Agregado a favoritos", Toast.LENGTH_LONG).show();
        }else{
            fav.setBackgroundResource(R.drawable.nofavorite);
            Toast.makeText(context, "Se elimina de favoritos", Toast.LENGTH_LONG).show();
        }*/
            }
        });
        //-------------Enlazar elementos------------------------

        img1.setImageBitmap(item.getImagen());
        titulo.setText(item.getTitulo());
        descripcion.setText(item.getDescripcion());
        valor.setText(item.getValor());
        fav.setTransitionName(item.getTitulo());
        if (item.getFavoritos() == 1) {
            fav.setImageResource(R.drawable.favorite);
        } else {
            fav.setImageResource(R.drawable.nofavorite);
        }


        //------------------------------------------------------------------------
        return view;
    }

}