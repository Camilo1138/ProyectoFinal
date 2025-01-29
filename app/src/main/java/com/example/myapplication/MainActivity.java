package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Botón para abrir CrearUserActivity
        Button buttonOpenSecondActivity = findViewById(R.id.startButton);
        buttonOpenSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CrearUserActivity.class);
                startActivity(intent);
            }
        });

       /* // Botón para abrir la actividad de administración de medicamentos
        Button buttonOpenMedicamentosActivity = findViewById(R.id.btn_medicamentos);
        buttonOpenMedicamentosActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MedicamentosActivity.class);
                startActivity(intent);
            }
        });

        */
    }


}