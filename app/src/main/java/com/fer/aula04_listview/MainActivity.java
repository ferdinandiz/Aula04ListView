package com.fer.aula04_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    EditText ed01;
    Button btn01;
    String texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lista);
        ed01 = findViewById(R.id.ed01);
        btn01 = findViewById(R.id.btn01);

        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Goku");
        nomes.add("Vegeta");
        nomes.add("Bulma");
        nomes.add("Krilin");
        nomes.add("Gohan");
        nomes.add("Picollo");
        nomes.add("Trunks");
        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                R.layout.lista_customizada,
                nomes);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Toast.makeText(
                        MainActivity.this,
                        "Clicou em: "+nomes.get(pos),
                        Toast.LENGTH_SHORT
                ).show();

            }
        });
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto = ed01.getText().toString();
                if(!texto.isEmpty()) {
                    nomes.add(texto);
                    adapter.notifyDataSetChanged();
                    lista.setAdapter(adapter);
                    ed01.setText("");
                    Toast.makeText(
                            MainActivity.this,
                            "Nome "+texto+" foi adicionado!",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });

    }
}