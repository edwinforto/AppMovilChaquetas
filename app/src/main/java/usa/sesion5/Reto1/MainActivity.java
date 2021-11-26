package usa.sesion5.Reto1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button boton1;
    TextView texto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = (Button) findViewById(R.id.boton1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto1.setText("hola otra vez..!");
                Toast.makeText(getApplicationContext(), "oprimio un boton", Toast.LENGTH_LONG ).show();
            }
        });

        texto1 = (TextView) findViewById(R.id.texto1);

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
        if (id == R.id.opcion1){
            Toast.makeText(getApplicationContext(), "Ya puedes ver nuestros productos", Toast.LENGTH_LONG ).show();
            Intent segundaPantalla = new Intent(this, MainActivity2.class);
            startActivity(segundaPantalla);
        }
        if (id == R.id.opcion2){
            Toast.makeText(getApplicationContext(), "Ya puedes ver nuestros servicios", Toast.LENGTH_LONG ).show();
            Intent terceraPantalla = new Intent(this, MainActivity3.class);
            startActivity(terceraPantalla);
        }
        if (id == R.id.opcion3){
            Toast.makeText(getApplicationContext(), "Ya puedes ver nuestras sorcusales", Toast.LENGTH_LONG ).show();
            Intent cuartaPantalla = new Intent(this, MainActivity4.class);
            startActivity(cuartaPantalla );
        }
        return super.onOptionsItemSelected(item);
    }
}