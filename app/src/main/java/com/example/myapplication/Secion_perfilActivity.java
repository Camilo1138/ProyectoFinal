package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class Secion_perfilActivity extends AppCompatActivity {
    private TextView tvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_secion_perfil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.secion), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation3);

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
/*
        setContentView(R.layout.activity_secion_perfil); // 💡 Debe estar antes de findViewById()

        tvName = findViewById(R.id.perfil); // 💡 Asegúrate de que el ID es correcto

        // Recupera el nombre del perfil del Intent
        PerFil perfilData = (PerFil) getIntent().getSerializableExtra("perfil_data");
        if (perfilData != null) {
            tvName.setText(perfilData.getNombre()); // 💡 Esto no fallará si el ID es correcto
        }

*/

        Button btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(v -> {
            // Aquí puedes cerrar sesión y volver a la pantalla de login
            Intent intent = new Intent(Secion_perfilActivity.this, SeleccionarPerfilActivity.class);
            startActivity(intent);
            finish(); // Cierra la actividad actual
        });
    }
}