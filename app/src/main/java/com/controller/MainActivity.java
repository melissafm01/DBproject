package com.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.melissa.basedatos.R;
import com.model.ManagerDB;

public class MainActivity extends AppCompatActivity {

    private ManagerDB managerDB;

    private EditText etCodigo, etCiudad, etDepartamento;
    private Button btnGuardarCiudad, btnActualizarCiudad, btnEliminarCiudad,
            btnGuardarDepartamento, btnActualizarDepartamento, btnEliminarDepartamento,
            btnVerActividades; // Nuevo botón para actividades
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar los objetos
        managerDB = new ManagerDB(this);
        etCodigo = findViewById(R.id.etCodigo);
        etCiudad = findViewById(R.id.etCiudad);
        etDepartamento = findViewById(R.id.etDepartamento);
        tvResultado = findViewById(R.id.tvResultado);

        // Botones existentes
        btnGuardarCiudad = findViewById(R.id.btnGuardarCiudad);
        btnActualizarCiudad = findViewById(R.id.btnActualizarCiudad);
        btnEliminarCiudad = findViewById(R.id.btnEliminarCiudad);
        btnGuardarDepartamento = findViewById(R.id.btnGuardarDepartamento);
        btnActualizarDepartamento = findViewById(R.id.btnActualizarDepartamento);
        btnEliminarDepartamento = findViewById(R.id.btnEliminarDepartamento);

        // Nuevo botón para actividades
        btnVerActividades = findViewById(R.id.btnVerActividades);

        // Acciones de los botones (se mantienen igual)
        btnGuardarCiudad.setOnClickListener(v -> guardarCiudad());
        btnActualizarCiudad.setOnClickListener(v -> actualizarCiudad());
        btnEliminarCiudad.setOnClickListener(v -> eliminarCiudad());
        btnGuardarDepartamento.setOnClickListener(v -> guardarDepartamento());
        btnActualizarDepartamento.setOnClickListener(v -> actualizarDepartamento());
        btnEliminarDepartamento.setOnClickListener(v -> eliminarDepartamento());

        // Acción para el nuevo botón de actividades
        btnVerActividades.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, lista_actividadesActivity.class);
            startActivity(intent);
        });
    }

    // Métodos existentes para Ciudad (se mantienen igual)
    private void guardarCiudad() {
        try {
            int codigo = Integer.parseInt(etCodigo.getText().toString().trim());
            String ciudad = etCiudad.getText().toString().trim();

            if (!ciudad.isEmpty()) {
                long resultado = managerDB.insertCiudad(codigo, ciudad);
                if (resultado > 0) {
                    tvResultado.setText("Ciudad guardada con éxito.");
                    Toast.makeText(MainActivity.this, "Ciudad guardada correctamente.", Toast.LENGTH_SHORT).show();
                } else {
                    tvResultado.setText("Error al guardar la ciudad.");
                    Toast.makeText(MainActivity.this, "Error al guardar la ciudad.", Toast.LENGTH_SHORT).show();
                }
                etCiudad.setText("");
            } else {
                tvResultado.setText("Por favor, ingresa el nombre de la ciudad.");
                Toast.makeText(MainActivity.this, "El nombre de la ciudad es obligatorio.", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            tvResultado.setText("El código debe ser un número válido.");
            Toast.makeText(MainActivity.this, "Ingresa un código numérico válido.", Toast.LENGTH_SHORT).show();
        }
    }

    private void actualizarCiudad() {
        try {
            int codigo = Integer.parseInt(etCodigo.getText().toString().trim());
            String ciudad = etCiudad.getText().toString().trim();

            if (!ciudad.isEmpty()) {
                int resultado = managerDB.updateCiudad(codigo, ciudad);
                if (resultado > 0) {
                    tvResultado.setText("Ciudad actualizada con éxito.");
                    Toast.makeText(MainActivity.this, "Ciudad actualizada correctamente.", Toast.LENGTH_SHORT).show();
                } else {
                    tvResultado.setText("Error al actualizar la ciudad.");
                    Toast.makeText(MainActivity.this, "Error al actualizar la ciudad.", Toast.LENGTH_SHORT).show();
                }
                etCiudad.setText("");
            } else {
                tvResultado.setText("Por favor, ingresa el nombre de la ciudad.");
                Toast.makeText(MainActivity.this, "El nombre de la ciudad es obligatorio.", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            tvResultado.setText("El código debe ser un número válido.");
            Toast.makeText(MainActivity.this, "Ingresa un código numérico válido.", Toast.LENGTH_SHORT).show();
        }
    }

    private void eliminarCiudad() {
        try {
            int codigo = Integer.parseInt(etCodigo.getText().toString().trim());
            int resultado = managerDB.deleteCiudad(codigo);
            if (resultado > 0) {
                tvResultado.setText("Ciudad eliminada con éxito.");
                Toast.makeText(MainActivity.this, "Ciudad eliminada correctamente.", Toast.LENGTH_SHORT).show();
            } else {
                tvResultado.setText("Error al eliminar la ciudad.");
                Toast.makeText(MainActivity.this, "Error al eliminar la ciudad.", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            tvResultado.setText("El código debe ser un número válido.");
            Toast.makeText(MainActivity.this, "Ingresa un código numérico válido.", Toast.LENGTH_SHORT).show();
        }
    }

    // Métodos existentes para Departamento (se mantienen igual)
    private void guardarDepartamento() {
        try {
            int codigo = Integer.parseInt(etCodigo.getText().toString().trim());
            String departamento = etDepartamento.getText().toString().trim();

            if (!departamento.isEmpty()) {
                long resultado = managerDB.insertDepartamento(codigo, departamento);
                if (resultado > 0) {
                    tvResultado.setText("Departamento guardado con éxito.");
                    Toast.makeText(MainActivity.this, "Departamento guardado correctamente.", Toast.LENGTH_SHORT).show();
                } else {
                    tvResultado.setText("Error al guardar el departamento.");
                    Toast.makeText(MainActivity.this, "Error al guardar el departamento.", Toast.LENGTH_SHORT).show();
                }
                etDepartamento.setText("");
            } else {
                tvResultado.setText("Por favor, ingresa el nombre del departamento.");
                Toast.makeText(MainActivity.this, "El nombre del departamento es obligatorio.", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            tvResultado.setText("El código debe ser un número válido.");
            Toast.makeText(MainActivity.this, "Ingresa un código numérico válido.", Toast.LENGTH_SHORT).show();
        }
    }

    private void actualizarDepartamento() {
        try {
            int codigo = Integer.parseInt(etCodigo.getText().toString().trim());
            String departamento = etDepartamento.getText().toString().trim();

            if (!departamento.isEmpty()) {
                int resultado = managerDB.updateDepartamento(codigo, departamento);
                if (resultado > 0) {
                    tvResultado.setText("Departamento actualizado con éxito.");
                    Toast.makeText(MainActivity.this, "Departamento actualizado correctamente.", Toast.LENGTH_SHORT).show();
                } else {
                    tvResultado.setText("Error al actualizar el departamento.");
                    Toast.makeText(MainActivity.this, "Error al actualizar el departamento.", Toast.LENGTH_SHORT).show();
                }
                etDepartamento.setText("");
            } else {
                tvResultado.setText("Por favor, ingresa el nombre del departamento.");
                Toast.makeText(MainActivity.this, "El nombre del departamento es obligatorio.", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            tvResultado.setText("El código debe ser un número válido.");
            Toast.makeText(MainActivity.this, "Ingresa un código numérico válido.", Toast.LENGTH_SHORT).show();
        }
    }

    private void eliminarDepartamento() {
        try {
            int codigo = Integer.parseInt(etCodigo.getText().toString().trim());
            int resultado = managerDB.deleteDepartamento(codigo);
            if (resultado > 0) {
                tvResultado.setText("Departamento eliminado con éxito.");
                Toast.makeText(MainActivity.this, "Departamento eliminado correctamente.", Toast.LENGTH_SHORT).show();
            } else {
                tvResultado.setText("Error al eliminar el departamento.");
                Toast.makeText(MainActivity.this, "Error al eliminar el departamento.", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            tvResultado.setText("El código debe ser un número válido.");
            Toast.makeText(MainActivity.this, "Ingresa un código numérico válido.", Toast.LENGTH_SHORT).show();
        }
    }
}