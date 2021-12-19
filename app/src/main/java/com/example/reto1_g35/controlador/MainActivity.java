package com.example.reto1_g35.controlador;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.reto1_g35.R;
import com.example.reto1_g35.modelo.ConsultarApi;
import com.example.reto1_g35.vista.Fragment_inicio;
import com.example.reto1_g35.vista.cart.CartFragment;
import com.example.reto1_g35.vista.favorites.FavoritesFragment;
import com.example.reto1_g35.vista.productos.ProductosFragment;
import com.example.reto1_g35.vista.servicios.ServiciosFragment;
import com.example.reto1_g35.vista.sucursales.SucursalesFragment;



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
        inicio = new Fragment_inicio();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragments, inicio).commit();

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
        inflater.inflate(R.menu.main_page, menu);
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
        if (id == R.id.nav_home){
            transicion = getSupportFragmentManager().beginTransaction();
            transicion.replace(R.id.contenedor_fragments, productos).addToBackStack(null).commit();
            Toast.makeText(getApplicationContext(), "Sección productos", Toast.LENGTH_LONG ).show();
        }
        if(id == R.id.main){
            transicion = getSupportFragmentManager().beginTransaction();
            transicion.replace(R.id.contenedor_fragments,inicio).addToBackStack(null).commit();
            Toast.makeText(this,"Página Principal ", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.nav_gallery){
            transicion = getSupportFragmentManager().beginTransaction();
            transicion.replace(R.id.contenedor_fragments, servicios).addToBackStack(null).commit();
            Toast.makeText(getApplicationContext(), "Seccion servicios", Toast.LENGTH_LONG ).show();
        }
        if (id == R.id.nav_slideshow){
            transicion = getSupportFragmentManager().beginTransaction();
            transicion.replace(R.id.contenedor_fragments, sucursal).addToBackStack(null).commit();
            Toast.makeText(getApplicationContext(), "Sección sucursales", Toast.LENGTH_LONG ).show();
        }

        if (id == R.id.favoritesIcon){
            transicion = getSupportFragmentManager().beginTransaction();
            transicion.replace(R.id.contenedor_fragments, favorites).addToBackStack(null).commit();
            Toast.makeText(getApplicationContext(), "Sección favoritos", Toast.LENGTH_LONG ).show();
        }
        if (id == R.id.miniCartIcon){
            transicion = getSupportFragmentManager().beginTransaction();
            transicion.replace(R.id.contenedor_fragments, cart).addToBackStack(null).commit();
            Toast.makeText(getApplicationContext(), "Sección cart", Toast.LENGTH_LONG ).show();
        }
        return super.onOptionsItemSelected(item);
    }
    //*****************************************************************************************************************


}