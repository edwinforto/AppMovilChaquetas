package com.example.tuchaqueta;

/**
 *
 *
 * @author Denisse Rincón
 */

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Resources;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Drawable drawable1, drawable2, drawable3;
    ImageView imagen2;
    ImageView imagen1;
    ImageView imagen3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //--------------------------------------------------------

        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.ch1, getTheme());

        imagen1 = (ImageView) findViewById(R.id.imagen1);
        imagen1.setImageDrawable(drawable1);

        //--------------------------------------------------------

        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.ch4, getTheme());

        imagen2 = (ImageView) findViewById(R.id.imagen2);
        imagen2.setImageDrawable(drawable2);

        //--------------------------------------------------------

        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.ch3, getTheme());

        imagen3 = (ImageView) findViewById(R.id.imagen3);
        imagen3.setImageDrawable(drawable3);

        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menuopciones, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (@NonNull MenuItem item){
            int id = item.getItemId();
            if (id == R.id.home) {
                Toast.makeText(getApplicationContext(), "regresa al inicio", Toast.LENGTH_LONG).show();
                Intent segundaPantalla = new Intent(this, MainActivity.class);
                startActivity(segundaPantalla);
            }
            if (id == R.id.productos) {
                Toast.makeText(getApplicationContext(), "conoce nuestros productos", Toast.LENGTH_LONG).show();
                Intent terceraPantalla = new Intent(this, MainActivity2.class);
                startActivity(terceraPantalla);
            }
            if (id == R.id.servicios) {
                Toast.makeText(getApplicationContext(), "conoce nuestros servicios", Toast.LENGTH_LONG).show();
                Intent cuartaPantalla = new Intent(this, MainActivity3.class);
                startActivity(cuartaPantalla);
            }
            if (id == R.id.sucursales) {
                Toast.makeText(getApplicationContext(), "visitanos", Toast.LENGTH_LONG).show();
                Intent cuartaPantalla = new Intent(this, MainActivity4.class);
                startActivity(cuartaPantalla);
            }
            return super.onOptionsItemSelected(item);
        }
    }