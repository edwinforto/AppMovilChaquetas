package com.example.reto1_g35;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.reto1_g35.ui.cart.CartFragment;
import com.example.reto1_g35.ui.favorites.FavoritesFragment;
import com.example.reto1_g35.ui.productos.ProductosFragment;
import com.example.reto1_g35.ui.servicios.ServiciosFragment;
import com.example.reto1_g35.ui.sucursales.SucursalesFragment;



public class MainActivity extends AppCompatActivity {
    Fragment cart;
    Fragment favorites;
    Fragment sucursal;
    Fragment servicios;
    Fragment productos;
    Fragment inicio;
    FragmentTransaction transicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cart = new CartFragment();
        favorites = new FavoritesFragment();
        sucursal = new SucursalesFragment();
        servicios = new ServiciosFragment();
        productos = new ProductosFragment();
        inicio = new Fragment_inicio();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragments, inicio).commit();

    }
    //****************************************** MENU DE OPCIONES ***************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home){
            transicion = getSupportFragmentManager().beginTransaction();
            transicion.replace(R.id.contenedor_fragments, productos).commit();
            Toast.makeText(getApplicationContext(), "Sección productos", Toast.LENGTH_LONG ).show();
        }
        if(id == R.id.main){
            transicion = getSupportFragmentManager().beginTransaction();
            transicion.replace(R.id.contenedor_fragments,inicio).commit();
            Toast.makeText(this,"Página Principal ", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.nav_gallery){
            transicion = getSupportFragmentManager().beginTransaction();
            transicion.replace(R.id.contenedor_fragments, servicios).commit();
            Toast.makeText(getApplicationContext(), "Seccion servicios", Toast.LENGTH_LONG ).show();
        }
        if (id == R.id.nav_slideshow){
            transicion = getSupportFragmentManager().beginTransaction();
            transicion.replace(R.id.contenedor_fragments, sucursal).commit();
            Toast.makeText(getApplicationContext(), "Sección sucursales", Toast.LENGTH_LONG ).show();
        }

        if (id == R.id.favoritesIcon){
            transicion = getSupportFragmentManager().beginTransaction();
            transicion.replace(R.id.contenedor_fragments, favorites).commit();
            Toast.makeText(getApplicationContext(), "Sección favoritos", Toast.LENGTH_LONG ).show();
        }
        if (id == R.id.miniCartIcon){
            transicion = getSupportFragmentManager().beginTransaction();
            transicion.replace(R.id.contenedor_fragments, cart).commit();
            Toast.makeText(getApplicationContext(), "Sección cart", Toast.LENGTH_LONG ).show();
        }
        return super.onOptionsItemSelected(item);
    }
    //*****************************************************************************************************************
}