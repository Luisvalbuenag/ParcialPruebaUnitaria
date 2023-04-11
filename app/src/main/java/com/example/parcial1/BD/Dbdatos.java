package com.example.parcial1.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbdatos extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "basededatosparcial.db";
    public static final  String TABLE_CONTACTO = "tablacontacto";
    Context context;

    public Dbdatos(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_CONTACTO+ "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "apellido TEXT NOT NULL," +
                "edad TEXT NOT NULL," +
                "telefono TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_CONTACTO);
        onCreate(sqLiteDatabase);


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

    public void deleteAllData() {

    }
}
