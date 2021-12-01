package com.example.tuchaquetav2;

/**
 *
 *
 * @author Denisse Rincón
 */

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Fragment subPantalla1, subPantalla2, subPantalla3, subPantallaInicio, subPantallaF;
    FragmentTransaction intercambio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subPantalla1 = new Fragment_Productos();
        subPantalla2 = new Fragment_Servicios();
        subPantalla3 = new Fragment_Sucursales();
        subPantallaInicio = new Fragment_inicio();
        subPantallaF = new Fragment_favoritos();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragments, subPantallaInicio).commit();

    }
    //****************************************** MENU DE OPCIONES ***************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.productos){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla1).commit();
            Toast.makeText(getApplicationContext(), "Estos son nuestros productos", Toast.LENGTH_LONG ).show();
        }
        if (id == R.id.servicios){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla2).commit();
            Toast.makeText(getApplicationContext(), "Conoce nuestros servicios", Toast.LENGTH_LONG ).show();
        }
        if (id == R.id.sucursales){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla3).commit();
            Toast.makeText(getApplicationContext(), "¡Visítanos!", Toast.LENGTH_LONG ).show();
        }
        if (id == R.id.home){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantallaInicio).commit();
            Toast.makeText(getApplicationContext(), "Comencemos", Toast.LENGTH_LONG ).show();
        }
        if (id == R.id.favoritos){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantallaF).commit();
            Toast.makeText(getApplicationContext(), "Tus favoritos", Toast.LENGTH_LONG ).show();
        }
        return super.onOptionsItemSelected(item);
    }
    //*****************************************************************************************************************
}