package com.example.reto3.modelo.producto;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.reto3.R;
import com.example.reto3.vista.productos.ProductosFragment;
import java.util.ArrayList;

public class AdaptadorProducto extends BaseAdapter {
    private ArrayList<EntidadProducto> listaProd;
    private Context context;
    FragmentTransaction transicion;
    Fragment productos;


    public AdaptadorProducto(ArrayList<EntidadProducto> listaProd, Context context) {
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

        EntidadProducto item = (EntidadProducto) getItem(pos);

        view = LayoutInflater.from(context).inflate(R.layout.item_productos, null);
        //------------------------------------------------------------------------
        ImageView img1 = (ImageView) view.findViewById(R.id.imagenItem);
        TextView titulo = (TextView) view.findViewById(R.id.nombreItem);
        TextView descripcion = (TextView) view.findViewById(R.id.descripcionItem);
        TextView valor = (TextView) view.findViewById(R.id.valorItem);
        //Button compra = (Button) view.findViewById(R.id.compra);
        ImageButton fav = (ImageButton) view.findViewById(R.id.imageFav);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("view--> "+view);
                Cursor cursor= ProductosFragment.actualizarFavoritos(item, context);
                if (cursor.getString(4).equals("TRUE")){
                    fav.setBackgroundResource(R.drawable.fav);
                    Toast.makeText(context, "Agregado a favoritos", Toast.LENGTH_LONG).show();
                }else{
                    fav.setBackgroundResource(R.drawable.nofavorite);
                    Toast.makeText(context, "Se elimina de favoritos", Toast.LENGTH_LONG).show();
                }
            }
        });
        //-------------Enlazar elementos------------------------

        img1.setImageResource(item.getImagen());
        titulo.setText(item.getTitulo());
        descripcion.setText(item.getDescripcion());
        valor.setText(item.getValor());
        fav.setTransitionName(item.getTitulo());
        if(item.getFavoritos().equals("TRUE")){
            fav.setImageResource(R.drawable.fav);
        }else{
            fav.setImageResource(R.drawable.nofavorite);
        }


        //------------------------------------------------------------------------
        return view;
    }




}

