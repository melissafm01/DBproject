package com.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ManagerDB {
    private final DbHelper dbHelper;
    private  SQLiteDatabase db;

    public ManagerDB(Context context) {
        dbHelper = new DbHelper(context);
            db = dbHelper.getWritableDatabase();

    }

    public long insertCiudad(int codigo, String nombre) {
        if (db == null || !db.isOpen()) {
            db = dbHelper.getWritableDatabase();
        }
        ContentValues valores = new ContentValues();
        valores.put("codigo", codigo);
        valores.put("nombre", nombre);
        return db.insert("Ciudad", null, valores);
    }

    public int updateCiudad(int codigo, String nuevoNombre) {
        if (db == null || !db.isOpen()) {
            db = dbHelper.getWritableDatabase();
        }
        ContentValues valores = new ContentValues();
        valores.put("nombre", nuevoNombre);
        return db.update("Ciudad", valores, "codigo = ?", new String[]{String.valueOf(codigo)});
    }

    public int deleteCiudad(int codigo) {
        if (db == null || !db.isOpen()) {
            db = dbHelper.getWritableDatabase();
        }
        return db.delete("Ciudad", "codigo = ?", new String[]{String.valueOf(codigo)});
    }


    public long insertDepartamento(int codigo, String nombre) {
        if (db == null || !db.isOpen()) {
            db = dbHelper.getWritableDatabase();
        }
        ContentValues valores = new ContentValues();
        valores.put("codigo", codigo);
        valores.put("nombre", nombre);
        return db.insert("Departamento", null, valores);
    }

    public int updateDepartamento(int codigo, String nuevoNombre) {
        if (db == null || !db.isOpen()) {
            db = dbHelper.getWritableDatabase();
        }
        ContentValues valores = new ContentValues();
        valores.put("nombre", nuevoNombre);
        return db.update("Departamento", valores, "codigo = ?", new String[]{String.valueOf(codigo)});
    }

    public int deleteDepartamento(int codigo) {
        if (db == null || !db.isOpen()) {
            db = dbHelper.getWritableDatabase();
        }
        return db.delete("Departamento", "codigo = ?", new String[]{String.valueOf(codigo)});
    }


    public long insertActividad(String titulo, String descripcion, String fecha, String lugar, String responsables) {
        if (db == null || !db.isOpen()) {
            db = dbHelper.getWritableDatabase();
        }
        ContentValues valores = new ContentValues();
        valores.put("titulo", titulo);
        valores.put("descripcion", descripcion);
        valores.put("fecha", fecha);
        valores.put("lugar", lugar);
        valores.put("responsables", responsables);
        return db.insert("Actividades", null, valores);
    }


    public int updateActividad(int id, String titulo, String descripcion, String fecha, String lugar, String responsables) {
        if (db == null || !db.isOpen()) {
            db = dbHelper.getWritableDatabase();
        }
        ContentValues valores = new ContentValues();
        valores.put("titulo", titulo);
        valores.put("descripcion", descripcion);
        valores.put("fecha", fecha);
        valores.put("lugar", lugar);
        valores.put("responsables", responsables);
        return db.update("Actividades", valores, "id = ?", new String[]{String.valueOf(id)});
    }


    public int deleteActividad(int id) {
        if (db == null || !db.isOpen()) {
            db = dbHelper.getWritableDatabase();
        }
        return db.delete("Actividades", "id = ?", new String[]{String.valueOf(id)});
    }


    public Cursor getAllActividades() {
        if (db == null || !db.isOpen()) {
            db = dbHelper.getReadableDatabase();
        }
        return db.query("Actividades",
                new String[]{"id", "titulo", "descripcion", "fecha", "lugar", "responsables"},
                null, null, null, null, "titulo ASC");
    }



    }
