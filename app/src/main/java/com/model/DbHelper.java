package com.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final String NAME_BD = "miBaseDatos.db";
    public static final int NUM_VERSION = 2;



    private static final String SQL_CREATE_ACTIVIDADES =
            "CREATE TABLE Actividades (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT NOT NULL," +
                    "descripcion TEXT," +
                    "fecha TEXT," +
                    "lugar TEXT," +
                    "responsables TEXT);";



    private static final String SQL_CREATE_CIUDAD =
            "CREATE TABLE Ciudad (codigo INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL);";

    private static final String SQL_CREATE_DEPARTAMENTO =
            "CREATE TABLE Departamento (codigo INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL);";

    public DbHelper(@Nullable Context context) {
        super(context, NAME_BD, null, NUM_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CIUDAD);
        db.execSQL(SQL_CREATE_DEPARTAMENTO);
        db.execSQL(SQL_CREATE_ACTIVIDADES); // Añade esta línea
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            db.execSQL("DROP TABLE IF EXISTS Actividades"); // Añade esta línea
            onCreate(db);
        }
    }
}