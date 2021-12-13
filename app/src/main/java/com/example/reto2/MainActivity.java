package com.example.reto2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Fragment mainScreen;
    private Fragment prod;
    private Fragment serv;
    private Fragment suc;
    private Fragment fav;
    private Fragment shoppingCar;
    private FragmentTransaction change;

    /**
     * inicialización de la pantalla Activity Main.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainScreen = new FragmentMain();
        prod = new Fragment_Productos();
        serv = new Fragment_Servicios();
        suc = new Fragment_Sucursales();
        fav = new Fragment_Favoritos();
        shoppingCar = new Fragment_ShoppingCar();

        getSupportFragmentManager().beginTransaction().add(R.id.containerFragment,mainScreen).commit();

    }
    //--------------------------MENU OPCIONES-------------------------------


    /**
     * creación del menu desplegable en la barra superior.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuoptions,menu);
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

        if(id == R.id.menu1){
            change = getSupportFragmentManager().beginTransaction();
            change.replace(R.id.containerFragment,prod).commit();
            Toast.makeText(this,"Ingreso a Productos", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.menu2){
            change = getSupportFragmentManager().beginTransaction();
            change.replace(R.id.containerFragment,serv).commit();
            Toast.makeText(this,"Ingreso a Servicios ", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.menu3){
            change = getSupportFragmentManager().beginTransaction();
            change.replace(R.id.containerFragment,suc).commit();
            Toast.makeText(this,"Ingreso a Sucursales ", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.iconB){
            change = getSupportFragmentManager().beginTransaction();
            change.replace(R.id.containerFragment,mainScreen).commit();
            Toast.makeText(this,"Página Principal ", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.icon2_B){
            change = getSupportFragmentManager().beginTransaction();
            change.replace(R.id.containerFragment,fav).commit();
            Toast.makeText(this,"Favoritos", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.icon3_B){
            change = getSupportFragmentManager().beginTransaction();
            change.replace(R.id.containerFragment,shoppingCar).commit();
            Toast.makeText(this,"Carrito de compras", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}