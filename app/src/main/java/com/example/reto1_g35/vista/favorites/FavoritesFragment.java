package com.example.reto1_g35.vista.favorites;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.reto1_g35.R;
import com.example.reto1_g35.modelo.DataBaseSQLController;
import com.example.reto1_g35.modelo.favoritos.AdaptadorFavoritos;
import com.example.reto1_g35.modelo.producto.AdaptadorProducto;
import com.example.reto1_g35.modelo.producto.EntidadProducto;
import com.example.reto1_g35.vista.productos.ProductosFragment;

import java.util.ArrayList;


public class FavoritesFragment extends Fragment {
    View v;

    private View view;
    private Cursor cursor;
    private ArrayList<EntidadProducto> listaProductos = new ArrayList<>();

    private ListView listViewProd;
    private AdaptadorFavoritos adaptadorFavorites;
    static DataBaseSQLController conector;

    public FavoritesFragment() {
        // Required empty public constructor
    }

    public static Cursor actualizarFavoritos(EntidadProducto item) {

        SQLiteDatabase db_read = conector.getReadableDatabase();
        if(item.getFavoritos().equals("FALSE")){
            db_read.execSQL(
                    "UPDATE productos SET favoritos =? WHERE titulo=?", new Object[]{"TRUE", item.getTitulo()});

        }else{
            db_read.execSQL(
                    "UPDATE productos SET favoritos =? WHERE titulo=?", new Object[]{"FALSE", item.getTitulo()});

        }
        Cursor cursor2 = db_read.rawQuery("SELECT * FROM productos WHERE titulo=\""+item.getTitulo()+"\"", null);
        cursor2.moveToNext();

        return cursor2;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favoritest, container, false);
        //--------------------------------------------------------------------------------
        listViewProd = (ListView) view.findViewById(R.id.viewFavorites);
        adaptadorFavorites = new AdaptadorFavoritos(getProdItems(),getActivity());
        listViewProd.setAdapter(adaptadorFavorites);

        //-----------------------------------------------------------------------------
        return view;
    }

    private ArrayList<EntidadProducto> getProdItems(){
        listaProductos= new ArrayList<>();
        conector = new DataBaseSQLController(this.getActivity(), "Productos", null, 1);
        cursor=null;
        SQLiteDatabase db_read = conector.getReadableDatabase();
        System.out.println("paso por aca cargando favoritos");
       // conector.onUpgrade(db_read,1,2);
        System.out.println("Conecto");
        cursor = db_read.rawQuery("SELECT * FROM productos WHERE favoritos ='TRUE'", null);
        System.out.println("Consulto db"+ cursor);

        //Escritura de elementos de la Base de Datos a la parte visual
        while (cursor.moveToNext()) {
            listaProductos.add(new EntidadProducto(ProductosFragment.listImg[cursor.getInt(0)],cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)));
            System.out.println("Data\t"+ cursor.getInt(0)+"\t"+ cursor.getString(1)+"\t"+cursor.getString(2)+"\t"+
                    cursor.getString(3)+"\t"+cursor.getString(4));

        }
        System.out.println("lista productos------> "+listaProductos.size());
        return listaProductos;
    }

}