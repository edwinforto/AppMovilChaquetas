package com.example.reto4.controlador;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.reto4.R;

import com.example.reto4.vista.InicioFragment;
import com.example.reto4.vista.sucursales.SucursalesFragment;
import com.example.reto4.vista.cart.CartFragment;
import com.example.reto4.vista.favoritos.FavoritesFragment;
import com.example.reto4.vista.productos.ProductosFragment;
import com.example.reto4.vista.servicios.ServiciosFragment;


public class MainActivity extends AppCompatActivity {
    /**
     * Declaracion de variables.
     */
    public static boolean isCreated=false;
    Fragment cart;
    Fragment favorites;
    Fragment sucursal;
    Fragment servicios;
    Fragment productos;
    Fragment inicio;
    FragmentTransaction transicion;

    /**
     * inicialización de la pantalla Activity Main.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cart = new CartFragment();
        favorites = new FavoritesFragment();
        sucursal = new SucursalesFragment();
        servicios = new ServiciosFragment();
        productos = new ProductosFragment();
        inicio = new InicioFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.containerFragment, inicio).commit();

    }
    //****************************************** MENU DE OPCIONES ***************************************************
    /**
     * creación del menu desplegable en la barra superior.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);
        return true;
    }
    /**
     * Acciones de los ítems del menú, que dirigen a sus respectivas pestañas.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu1){
            transicion = getSupportFragmentManager().beginTransaction();
            transicion.replace(R.id.containerFragment, productos).addToBackStack(null).commit();
            Toast.makeText(getApplicationContext(), "Sección productos", Toast.LENGTH_LONG ).show();
        }
        //if(id == R.id.main){
        //    transicion = getSupportFragmentManager().beginTransaction();
        //    transicion.replace(R.id.containerFragment,inicio).commit();
        //    Toast.makeText(this,"Página Principal ", Toast.LENGTH_SHORT).show();
        //}
        if (id == R.id.menu2){
            transicion = getSupportFragmentManager().beginTransaction();
            transicion.replace(R.id.containerFragment, servicios).commit();
            Toast.makeText(getApplicationContext(), "Seccion servicios", Toast.LENGTH_LONG ).show();
        }
        if (id == R.id.menu3){
            transicion = getSupportFragmentManager().beginTransaction();
            transicion.replace(R.id.containerFragment, sucursal).commit();
            Toast.makeText(getApplicationContext(), "Sección sucursales", Toast.LENGTH_LONG ).show();
        }

        if (id == R.id.icon2_B){
            transicion = getSupportFragmentManager().beginTransaction();
            transicion.replace(R.id.containerFragment, favorites).addToBackStack(null).commit();
            Toast.makeText(getApplicationContext(), "Sección favoritos", Toast.LENGTH_LONG ).show();
        }
        if (id == R.id.icon3_B){
            transicion = getSupportFragmentManager().beginTransaction();
            transicion.replace(R.id.containerFragment, cart).commit();
            Toast.makeText(getApplicationContext(), "Sección cart", Toast.LENGTH_LONG ).show();
        }
        return super.onOptionsItemSelected(item);
    }
    //*****************************************************************************************************************


}