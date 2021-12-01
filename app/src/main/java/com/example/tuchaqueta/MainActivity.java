package com.example.tuchaqueta;

/**
 *
 *
 * @author Denisse Rincón
 */

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            Intent primeraPantalla = new Intent(this, MainActivity.class);
            startActivity(primeraPantalla);
        }
        if (id == R.id.productos){
            Toast.makeText(getApplicationContext(), "conoce nuestros productos", Toast.LENGTH_LONG ).show();
            Intent segundaPantalla = new Intent(this, MainActivity2.class);
            startActivity(segundaPantalla);
        }
        if (id == R.id.servicios){
            Toast.makeText(getApplicationContext(), "conoce nuestros servicios", Toast.LENGTH_LONG ).show();
            Intent terceraPantalla = new Intent(this, MainActivity3.class);
            startActivity(terceraPantalla );
        }
        if (id == R.id.sucursales){
            Toast.makeText(getApplicationContext(), "visitanos", Toast.LENGTH_LONG ).show();
            Intent cuartaPantalla = new Intent(this, MainActivity4.class);
            startActivity(cuartaPantalla );
        }
        return super.onOptionsItemSelected(item);
    }
}