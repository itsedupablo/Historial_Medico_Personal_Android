package com.example.historialmedicopersonal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.historialmedicopersonal.navigation.ConsultasFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.historialmedicopersonal.navigation.RecetasFragment;
import com.example.historialmedicopersonal.navigation.ResultadosFragment;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cargar el primer fragmento (Consultas) al abrir la app
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ConsultasFragment())
                    .commit();
        }

        // Configurar el BottomNavigationView para navegar entre fragmentos
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment;
           if (item.getItemId() == R.id.navigation_consultas) {
               selectedFragment = new ConsultasFragment();
              } else if (item.getItemId() == R.id.navigation_recetas) {
                selectedFragment = new RecetasFragment();
                } else if (item.getItemId() == R.id.navigation_resultados) {
                selectedFragment = new ResultadosFragment();
                } else {
                return false;
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
            return true;
        });
    }
}

