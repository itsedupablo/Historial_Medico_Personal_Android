package com.example.historialmedicopersonal;

import com.example.historialmedicopersonal.navigation.HistorialFragment;
import com.example.historialmedicopersonal.navigation.MedicacionFragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar el Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);  // Obtener la referencia al Toolbar
        setSupportActionBar(toolbar);  // Establecer el Toolbar como ActionBar
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar el menú desde el XML
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Manejar la selección de opciones en el menú
        if (item.getItemId() == R.id.navigation_historial) {
            loadFragment(new HistorialFragment());  // Cargar el fragmento de Historial
            return true;

        } else if (item.getItemId() == R.id.navigation_medicacion) {
            loadFragment(new MedicacionFragment());  // Cargar el fragmento de Medicación
            return true;

        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void loadFragment(Fragment fragment) {
        // Cargar el fragmento correspondiente en el contenedor
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
