package com.example.reto2;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private ImageView cuero;
    private ImageView impermeable;
    private ImageView pana;
    private ImageView capucha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cuero = (ImageView) findViewById(R.id.imagen1_prod);
        impermeable = (ImageView) findViewById(R.id.imagen2_prod);
        pana = (ImageView) findViewById(R.id.imagen3_prod);

        cuero.setOnClickListener(this);
        impermeable.setOnClickListener(this);
        pana.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuoptions2,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        if(id == R.id.menu2){
            Toast.makeText(this,"Ingreso a Servicios ", Toast.LENGTH_SHORT).show();
            Intent secondScreen = new Intent(getApplicationContext(),MainActivity3.class);
            startActivity(secondScreen);
        }
        if(id == R.id.menu3){
            Toast.makeText(this,"Ingreso a Sucursales", Toast.LENGTH_SHORT).show();
            Intent secondScreen = new Intent(getApplicationContext(),MainActivity4.class);
            startActivity(secondScreen);
        }
        if(id== R.id.icon){
            Intent secondScreen = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(secondScreen);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.imagen1_prod:
                Toast.makeText(this,"Acceder a info de chaqueta de cuero ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imagen2_prod:
                Toast.makeText(this,"Acceder a info de chaqueta impermeable", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imagen3_prod:
                Toast.makeText(this,"Acceder a info de chaqueta juvenil ", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}