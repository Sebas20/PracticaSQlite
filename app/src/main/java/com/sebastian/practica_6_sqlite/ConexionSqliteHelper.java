package com.sebastian.practica_6_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sebastian.practica_6_sqlite.Utilidades.Utilidades;

/**
 * Created by Usuario on 1/11/2017.
 */

public class ConexionSqliteHelper extends SQLiteOpenHelper {



    public ConexionSqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int VersionAntigua, int VersionNueva) {
        db.execSQL("DROP TABLE IF EXISTS usuarios ");
        onCreate(db);

    }
}
