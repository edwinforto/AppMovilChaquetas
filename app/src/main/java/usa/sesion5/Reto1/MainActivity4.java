package usa.sesion5.Reto1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    Drawable drawable1, drawable2, drawable3;
    ImageView imagen1, imagen2, imagen3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //--------------------------------------------------------

        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.plaza_americs, getTheme());

        imagen1 = (ImageView) findViewById(R.id.imagen1_surc);
        imagen1.setImageDrawable(drawable1);

        //--------------------------------------------------------

        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.santafe, getTheme());

        imagen2= (ImageView) findViewById(R.id.imagen2_surc);
        imagen2.setImageDrawable(drawable2);

        //--------------------------------------------------------

        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.salitre_plaza, getTheme());

        imagen3= (ImageView) findViewById(R.id.imagen3_surc);
        imagen3.setImageDrawable(drawable3);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menusurcusales, menu);
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