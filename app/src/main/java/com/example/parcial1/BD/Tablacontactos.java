package com.example.parcial1.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class Tablacontactos extends Dbdatos{
    Context context;

    public Tablacontactos (@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insetarDatos(String nombre, String apellido,String edad,String telefono){

        long id = 0;
        try {

            Dbdatos datab = new Dbdatos(context);
            SQLiteDatabase db = datab.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("nombre", nombre);
            valores.put("apellido", apellido);
            valores.put("edad", edad);
            valores.put("telefono", telefono);


            id = db.insert(TABLE_CONTACTO, null, valores);
        } catch(Exception ex){
            ex.toString();
        }
        return id;
    }

}