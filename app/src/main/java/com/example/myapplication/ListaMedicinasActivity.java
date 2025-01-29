package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListaMedicinasActivity extends AppCompatActivity {

    private ListView lvListaMedicinas;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> listaMedicinas = new ArrayList<>();
    private static final String FILE_NAME = "medicines_data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_medicinas);

        lvListaMedicinas = findViewById(R.id.lv_lista_medicinas);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaMedicinas);
        lvListaMedicinas.setAdapter(adapter);

        cargarMedicinasDesdeArchivo();

        Button btnRegresar = findViewById(R.id.btnregresar);
        btnRegresar.setOnClickListener(v -> {
            finish();
        });



    }

    private void cargarMedicinasDesdeArchivo() {
        listaMedicinas.clear();
        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String linea;
            while ((linea = reader.readLine()) != null) {
                listaMedicinas.add(linea);
            }
            reader.close();
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            Toast.makeText(this, "No se pudieron cargar las medicinas", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, AgregarMedicinaActivity.class);
        startActivity(intent);
        finish();
    }


}
