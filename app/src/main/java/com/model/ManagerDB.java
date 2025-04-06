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

    // Funciones para Ciudad (se mantienen igual)
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

    // Funciones para Departamento (se mantienen igual)
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

    // ===== NUEVAS FUNCIONES PARA ACTIVIDADES =====

    /**
     * Inserta una nueva actividad en la base de datos
     */
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

    /**
     * Actualiza una actividad existente
     */
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

    /**
     * Elimina una actividad por su ID
     */
    public int deleteActividad(int id) {
        if (db == null || !db.isOpen()) {
            db = dbHelper.getWritableDatabase();
        }
        return db.delete("Actividades", "id = ?", new String[]{String.valueOf(id)});
    }

    /**
     * Obtiene todas las actividades ordenadas por título
     */
    public Cursor getAllActividades() {
        if (db == null || !db.isOpen()) {
            db = dbHelper.getReadableDatabase();
        }
        return db.query("Actividades",
                new String[]{"id", "titulo", "descripcion", "fecha", "lugar", "responsables"},
                null, null, null, null, "titulo ASC");
    }

    /**
     * Obtiene una actividad específica por su ID
     */
    public Cursor getActividadById(int id) {
        if (db == null || !db.isOpen()) {
            db = dbHelper.getReadableDatabase();
        }
        return db.query("Actividades",
                new String[]{"id", "titulo", "descripcion", "fecha", "lugar", "responsables"},
                "id = ?", new String[]{String.valueOf(id)},
                null, null, null);
    }


    }
