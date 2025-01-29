package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class actividadesActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_actividades);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.actividades), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation2);

        // Mapeo de IDs a clases de actividad
        Map<Integer, Class<?>> activityMap = new HashMap<>();
        activityMap.put(R.id.nav_home, InicioActivity.class);
        activityMap.put(R.id.nav_profile, Secion_perfilActivity.class);
        activityMap.put(R.id.nav_act, actividadesActivity.class);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Class<?> activityClass = activityMap.get(item.getItemId());
            if (activityClass != null) {
                startActivity(new Intent(this, activityClass));
            }
            return true;
        });
        Button btnMedicos = findViewById(R.id.btn_medicos);
        btnMedicos.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListadoMedicosActivity.class);
            startActivity(intent);
        });
        Button btn_medicamentos = findViewById(R.id.btn_medicamentos);
        btn_medicamentos.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListaMedicinasActivity.class);
            startActivity(intent);
        });
        Button btn_citas = findViewById(R.id.btn_citas);
        btn_citas.setOnClickListener(v -> {
            Intent intent = new Intent(this, CitasActivity.class);
            startActivity(intent);
        });

        Button btn_actividades = findViewById(R.id.btn_actividades);
        btn_actividades.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActividadFisicaActivity.class);
            startActivity(intent);
        });
    }
}