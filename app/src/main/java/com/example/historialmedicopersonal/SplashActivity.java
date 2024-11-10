package com.example.historialmedicopersonal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Usamos un Handler para hacer que espere 2 segundos antes de abrir la MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Una vez pasado el tiempo, iniciamos la MainActivity
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Cierra la SplashActivity para que no pueda volver atrás
            }
        }, 2000); // 2000 milisegundos = 2 segundos
    }
}
