package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText usuario;
    EditText contrasena;
    Button btningreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.usuario1);
        contrasena = findViewById(R.id.contraseña1);
        btningreso = findViewById(R.id.btn);


    btningreso.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent Siguiente = new Intent(MainActivity.this,Datos.class);

            startActivity(Siguiente);
        }


    });
    }
}