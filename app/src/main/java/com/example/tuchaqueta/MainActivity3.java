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

public class MainActivity3 extends AppCompatActivity {

    Drawable drawable4, drawable5;
    ImageView imagen4;
    ImageView imagen5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //--------------------------------------------------------

        Resources res4 = getResources();
        drawable4 = res4.getDrawable(R.drawable.s1, getTheme());

        imagen4= (ImageView) findViewById(R.id.imagen4);
        imagen4.setImageDrawable(drawable4);

        //--------------------------------------------------------

        Resources res5 = getResources();
        drawable5 = res5.getDrawable(R.drawable.s2, getTheme());

        imagen5 = (ImageView) findViewById(R.id.imagen5);
        imagen5.setImageDrawable(drawable5);

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