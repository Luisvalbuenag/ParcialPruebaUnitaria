package com.example.parcial1;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DatosTest {

    private Datos datos;
    private EditText editnombre;
    private EditText editedad;
    private EditText edittelefono;
    private EditText editApellido;
    private Button guardar;

    @Before
    public void setUp() {
        datos = new Datos();
        datos.onCreate(null);

        editnombre = datos.findViewById(R.id.editnombre);
        editedad = datos.findViewById(R.id.editedad);
        edittelefono = datos.findViewById(R.id.edittelefono);
        editApellido = datos.findViewById(R.id.editapellido);
        guardar = datos.findViewById(R.id.BtnGuardar);
    }

    @Test
    public void testOnClick() {
        // Establecer los valores de las vistas de edición
        editnombre.setText("Luis");
        editedad.setText("30");
        edittelefono.setText("1234567890");
        editApellido.setText("Galindo");

        // Hacer clic en el botón "Guardar"
        guardar.performClick();

        // Verificar que las vistas de edición están vacías después de guardar
        assertEquals("", editnombre.getText().toString());
        assertEquals("", editedad.getText().toString());
        assertEquals("", edittelefono.getText().toString());
        assertEquals("", editApellido.getText().toString());
    }
}