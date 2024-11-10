package com.example.historialmedicopersonal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.example.historialmedicopersonal.navigation.ConsultasFragment;
import com.example.historialmedicopersonal.navigation.RecetasFragment;
import com.example.historialmedicopersonal.navigation.ResultadosFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuración para cargar el fragmento inicial
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ConsultasFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar el menú de opciones en la esquina superior derecha
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment selectedFragment = null;

        // Maneja la selección de cada opción del menú
        if (item.getItemId() == R.id.navigation_consultas) {
            selectedFragment = new ConsultasFragment();
        } else if (item.getItemId() == R.id.navigation_recetas) {
            selectedFragment = new RecetasFragment();
        } else if (item.getItemId() == R.id.navigation_resultados) {
            selectedFragment = new ResultadosFragment();
        }

        // Reemplaza el fragmento actual por el seleccionado
        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
        }

        return true;
    }
}
