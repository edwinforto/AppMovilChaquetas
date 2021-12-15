package com.example.reto3.modelo;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DataBaseSQLController extends SQLiteOpenHelper{

    public DataBaseSQLController(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {


        //******************************* TABLA PRODUCTOS***************************
        //Crear tabla
        database.execSQL("CREATE TABLE productos (img INT, titulo TEXT, descripcion TEXT, valor TEXT, favoritos TEXT)");

        //Insertar Data tabla Productos
        database.execSQL("INSERT INTO productos VALUES (0,'Cuero','Chaqueta de cuero', 'Valor:\t$650.990', 'FALSE')");
        database.execSQL("INSERT INTO productos VALUES (1,'Impermeable','Chaqueta Impermeable', 'Valor:\t$450.900', 'TRUE')");
        database.execSQL("INSERT INTO productos VALUES (2,'Juvenil','Chaqueta Juvenil', 'Valor:\t$100.900', 'FALSE')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        System.out.println("++++++++reiniciando tabla");
        database.execSQL("DROP TABLE productos");
        onCreate(database);

    }
}

