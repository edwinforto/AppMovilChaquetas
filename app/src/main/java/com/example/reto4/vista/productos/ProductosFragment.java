package com.example.reto4.vista.productos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.reto4.R;
import com.example.reto4.controlador.MainActivity;
import com.example.reto4.modelo.DataBaseSQLController;
import com.example.reto4.modelo.producto.AdaptadorProducto;
import com.example.reto4.modelo.producto.EntidadProducto;

import java.util.ArrayList;


public class ProductosFragment extends Fragment {

    View v;
    public static int[] listImg = {R.drawable.chaquetacuero,R.drawable.chaquetasintetica,R.drawable.chaqutajuvenil};

    private View view;
    private Cursor cursor;
    private ArrayList<EntidadProducto> listaProductos = new ArrayList<>();
    private ListView listViewProd;
    private AdaptadorProducto adaptadorProducto;


    public ProductosFragment() {
        // Required empty public constructor
    }

    public static Cursor actualizarFavoritos(EntidadProducto item,  Context activity) {

        DataBaseSQLController conector = new DataBaseSQLController(activity, "Productos", null, 1);
        SQLiteDatabase db_read = conector.getReadableDatabase();
        System.out.println("here1--> "+item.getFavoritos());
        if(item.getFavoritos().equals("FALSE")){
            System.out.println("here2");
            item.setFavoritos("TRUE");
            db_read.execSQL(
                    "UPDATE productos SET favoritos =? WHERE titulo=?", new Object[]{"TRUE", item.getTitulo()});
        }else{
            System.out.println("here3");
            item.setFavoritos("FALSE");
            db_read.execSQL(
                    "UPDATE productos SET favoritos =? WHERE titulo=?", new Object[]{"FALSE", item.getTitulo()});
        }
        Cursor cursor2 = db_read.rawQuery("SELECT * FROM productos WHERE titulo=\""+item.getTitulo()+"\"", null);
        cursor2.moveToNext();
        System.out.println("actualizacion tabla--> "+item.getTitulo()+"--"+cursor2.getString(0)+
                cursor2.getString(1)+cursor2.getString(2)+ cursor2.getString(3)+ cursor2.getString(4));
        return cursor2;


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
        DataBaseSQLController conector ;//=new DataBaseSQLController(this.getActivity(), "Productos", null, 1);
        conector = new DataBaseSQLController(this.getActivity(), "Productos", null, 1);

        SQLiteDatabase db_read = conector.getReadableDatabase();
        if(!MainActivity.isCreated){
            conector.onUpgrade(db_read,1,2);
            MainActivity.isCreated=true;
        }
        cursor = db_read.rawQuery("SELECT * FROM productos", null);


        //Escritura de elementos de la Base de Datos a la parte visual
        while (cursor.moveToNext()) {
            listaProductos.add(new EntidadProducto(listImg[cursor.getInt(0)],cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4)));


        }
        return listaProductos;
    }

}