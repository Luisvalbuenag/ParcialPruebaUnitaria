package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcial1.BD.Dbdatos;
import com.example.parcial1.BD.Tablacontactos;

public class Datos extends AppCompatActivity {

    EditText editnombre;
    EditText editedad;
    EditText edittelefono;
    EditText editApellido;
    Button guardar;
    Dbdatos DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        editnombre = findViewById(R.id.editnombre);
        editedad = findViewById(R.id.editedad);
        edittelefono = findViewById(R.id.edittelefono);
        editApellido = findViewById(R.id.editapellido);
        guardar = findViewById(R.id.BtnGuardar);
        DB = new Dbdatos(this);

        guardar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Tablacontactos dbtablacontactos = new Tablacontactos(Datos.this);
                long id = dbtablacontactos.insetarDatos(editnombre.getText().toString(), editApellido.getText().toString(), editedad.getText().toString(), edittelefono.getText().toString());

                if (id > 0) {
                    Toast.makeText(Datos.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                    Eliminarinfo();
                } else {
                    Toast.makeText(Datos.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private void Eliminarinfo (){

        editnombre.setText("");
        editedad.setText("");
        editApellido.setText("");
        edittelefono.setText("");
    }
}
