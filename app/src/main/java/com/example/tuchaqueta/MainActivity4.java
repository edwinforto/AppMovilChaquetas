package com.example.tuchaqueta;

/**
 *
 *
 * @author Denisse Rincón
 */

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    Drawable drawable6, drawable7,drawable8, drawable9;
    ImageView imagen6;
    ImageView imagen7;
    ImageView imagen8;
    ImageView imagen9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //--------------------------------------------------------

        Resources res6 = getResources();
        drawable6 = res6.getDrawable(R.drawable.cc1, getTheme());

        imagen6= (ImageView) findViewById(R.id.imagen6);
        imagen6.setImageDrawable(drawable6);

        //--------------------------------------------------------

        Resources res7 = getResources();
        drawable7 = res7.getDrawable(R.drawable.cc2, getTheme());

        imagen7 = (ImageView) findViewById(R.id.imagen7);
        imagen7.setImageDrawable(drawable7);
        //--------------------------------------------------------

        Resources res8 = getResources();
        drawable8 = res8.getDrawable(R.drawable.cc3, getTheme());

        imagen8= (ImageView) findViewById(R.id.imagen8);
        imagen8.setImageDrawable(drawable8);

        //--------------------------------------------------------

        Resources res9 = getResources();
        drawable9 = res9.getDrawable(R.drawable.cc4, getTheme());

        imagen9 = (ImageView) findViewById(R.id.imagen9);
        imagen9.setImageDrawable(drawable9);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home){
            Toast.makeText(getApplicationContext(), "regresa al inicio", Toast.LENGTH_LONG ).show();
            Intent segundaPantalla = new Intent(this, MainActivity.class);
            startActivity(segundaPantalla);
        }
        if (id == R.id.productos){
            Toast.makeText(getApplicationContext(), "conoce nuestros productos", Toast.LENGTH_LONG ).show();
            Intent terceraPantalla = new Intent(this, MainActivity2.class);
            startActivity(terceraPantalla);
        }
        if (id == R.id.servicios){
            Toast.makeText(getApplicationContext(), "conoce nuestros servicios", Toast.LENGTH_LONG ).show();
            Intent cuartaPantalla = new Intent(this, MainActivity3.class);
            startActivity(cuartaPantalla );
        }
        if (id == R.id.sucursales){
            Toast.makeText(getApplicationContext(), "visitanos", Toast.LENGTH_LONG ).show();
            Intent cuartaPantalla = new Intent(this, MainActivity4.class);
            startActivity(cuartaPantalla );
        }
        return super.onOptionsItemSelected(item);
    }
}