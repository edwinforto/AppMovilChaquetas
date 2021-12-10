package com.example.reto1_g35.vista.productos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.reto1_g35.R;
import com.example.reto1_g35.modelo.DataBaseSQLController;
import com.example.reto1_g35.modelo.producto.AdaptadorProducto;
import com.example.reto1_g35.modelo.producto.EntidadProducto;

import java.time.Clock;
import java.util.ArrayList;


public class ProductosFragment extends Fragment {
    View v;

    private View view;
    private Cursor cursor;
    private ArrayList<EntidadProducto> listaProductos = new ArrayList<>();
    private int[] listImg = {R.drawable.catalogohombre3,R.drawable.catalogohombre3,R.drawable.catalogmujer3,
            R.drawable.catalogohombre3, R.drawable.catalogohombre3};
    private ListView listViewProd;
    private AdaptadorProducto adaptadorProducto;

    public ProductosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_productos, container, false);
        //--------------------------------------------------------------------------------
        listViewProd = (ListView) view.findViewById(R.id.viewProducts);
        adaptadorProducto = new AdaptadorProducto(getProdItems(),getActivity());
        listViewProd.setAdapter(adaptadorProducto);

        //-----------------------------------------------------------------------------
        return view;
    }

    private ArrayList<EntidadProducto> getProdItems(){
        DataBaseSQLController conector = new DataBaseSQLController(this.getActivity(), "Productos", null, 1);

        SQLiteDatabase db_read = conector.getReadableDatabase();

        conector.onUpgrade(db_read,1,2);
        cursor = db_read.rawQuery("SELECT * FROM productos", null);
System.out.println(cursor.toString());

        //Escritura de elementos de la Base de Datos a la parte visual
        while (cursor.moveToNext()) {
            listaProductos.add(new EntidadProducto(listImg[cursor.getInt(0)],cursor.getString(1),cursor.getString(2),cursor.getString(3),Boolean.getBoolean(cursor.getString(4))));


        }
        return listaProductos;
    }

}