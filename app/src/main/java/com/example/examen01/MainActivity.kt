package com.example.examen01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var botonAceptar: Button
    private lateinit var inputCodigo: EditText
    private lateinit var inputDescripcion: EditText
    private lateinit var inputCategoria: EditText
    private lateinit var inputMinimo: EditText
    private lateinit var inputMaximo: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonAceptar = findViewById(R.id.botonAceptar)
        inputCodigo = findViewById(R.id.inputCodigo)
        inputDescripcion = findViewById(R.id.inputDescripcion)
        inputCategoria = findViewById(R.id.inputCategoria)
        inputMinimo = findViewById(R.id.inputMinimo)
        inputMaximo = findViewById(R.id.inputMaximo)

        botonAceptar.setOnClickListener {
            // Valida los campos
            if (validarCampos()) {
                // Muestra un mensaje de registro exitoso
                Toast.makeText(this, R.string.registrado, Toast.LENGTH_SHORT).show()

                // Limpia los campos
                inputCodigo.text.clear()
                inputDescripcion.text.clear()
                inputCategoria.text.clear()
                inputMinimo.text.clear()
                inputMaximo.text.clear()
            }
        }
    }

    // Validar los campos
    private fun validarCampos(): Boolean {
        val codigo = inputCodigo.text.toString()
        val descripcion = inputDescripcion.text.toString()
        val categoria = inputCategoria.text.toString()
        val minimo = inputMinimo.text.toString()
        val maximo = inputMaximo.text.toString()

        // Verifica si los campos numéricos son mayores a cero
        if (codigo.isEmpty() || descripcion.isEmpty() || categoria.isEmpty() || minimo.isEmpty() || maximo.isEmpty()) {
            Toast.makeText(this, R.string.obligatorio, Toast.LENGTH_SHORT).show()
            return false
        }

        if (minimo.toInt() <= 0 || maximo.toInt() <= 0) {
            Toast.makeText(this, R.string.mayorACero, Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}
