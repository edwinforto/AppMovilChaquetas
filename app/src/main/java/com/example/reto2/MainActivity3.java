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

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    private ImageView buy;
    private ImageView clean;
    private ImageView change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        buy = (ImageView) findViewById(R.id.imagen1_serv);
        clean = (ImageView) findViewById(R.id.imagen2_serv);
        change = (ImageView) findViewById(R.id.imagen3_serv);

        buy.setOnClickListener(this);
        clean.setOnClickListener(this);
        change.setOnClickListener(this);

    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuoptions3,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.menu1){
            Toast.makeText(this,"Ingreso a Productos ", Toast.LENGTH_SHORT).show();
            Intent secondScreen = new Intent(getApplicationContext(),MainActivity2.class);
            startActivity(secondScreen);
        }
        if(id == R.id.menu3){
            Toast.makeText(this,"Ingreso a Sucursales ", Toast.LENGTH_SHORT).show();
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

            case R.id.imagen1_serv:
                Toast.makeText(this, "entras a realizar una compra", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imagen2_serv:
                Toast.makeText(this, "entras a enviar la chaqueta a lavar", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imagen3_serv:
                Toast.makeText(this, "entras a intercambiar la chaqueta", Toast.LENGTH_SHORT).show();
        }

    }
}