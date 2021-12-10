package com.example.reto1_g35.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseSQLController extends SQLiteOpenHelper {

    public DataBaseSQLController(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {


        //******************************* TABLA PRODUCTOS***************************
        //Crear tabla
        database.execSQL("CREATE TABLE productos (img INT, titulo TEXT, descripcion TEXT, valor TEXT, favoritos TEXT)");

        //Insertar Data tabla Productos
        database.execSQL("INSERT INTO productos VALUES (0,'La Chamarra','Chaqueta Aimar', 'Valor:\t$144.990', 'FALSE')");
        database.execSQL("INSERT INTO productos VALUES (1,'Ambiance','Chaqueta Alphonse', 'Valor:\t$223.900', 'FALSE')");
        database.execSQL("INSERT INTO productos VALUES (2,'Generic','Chaqueta Rompeviento', 'Valor:\t$106.900', 'FALSE')");
        database.execSQL("INSERT INTO productos VALUES (3,'Desigual','Chaqueta Virginia', 'Valor:\t$282.990', 'FALSE')");
        database.execSQL("INSERT INTO productos VALUES (4,'Paris District','Chaqueta Gem', 'Valor:\t$379.990', 'FALSE')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
       database.execSQL("DROP TABLE productos");
       onCreate(database);

    }
}
