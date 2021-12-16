package com.example.reto4.vista;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.reto4.controlador.MainActivity;
import com.example.reto4.R;


public class SplashScreen extends AppCompatActivity {
    private Thread hilo1;
    private ImageView iconoCarga;
    private ProgressBar barraProgreso;
    private TextView percent;
    private Handler handler = new Handler();
    private int number = 0;
    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // iconoCarga.setImageResource(R.drawable.catalogohombre12);
        percent = (TextView) findViewById(R.id.percent);

        hilo1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (number <= 100) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            percent.setText(number + " %");

                        }
                    });
                    try {
                        Thread.sleep(50);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (number == 100) {
                        pasarPantalla = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(pasarPantalla);
                    }
                    number++;
                }
            }
        });
        hilo1.start();
    }

}

