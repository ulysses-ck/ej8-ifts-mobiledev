package com.example.ej8_ifts_mobiledev

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    /* Nos solicitan elaborar un algoritmo que nos permita establecer si un  ́angulo es AGUDO, RECTO, OBTUSO,
    LLANO o CO ́NCAVO. Recordemos que: Agudo si es menor a 90 . Obtuso si es mayor que 90 pero menor que
    180 . Recto si es igual a 90 . Llano si es igual a 180 y Concavo si es mayor que 180 y menor que 360 . En caso
    de que se ingrese un  ́angulo err ́oneo, indicarlo al usuario. Recordar la existencia del  ́angulo nulo de 0 y completo
    de 360 */

    private lateinit var angleEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        angleEditText = findViewById(R.id.angleEditText)
        resultTextView = findViewById(R.id.resultTextView)
        calculateButton = findViewById(R.id.calculateButton)

        calculateButton.setOnClickListener() {
            val angle = angleEditText.text.toString().toDouble()
            var angleType: String
            if (angle < 90) {
                angleType = "AGUDO"
            } else if (angle == 90.0) {
                angleType = "RECTO"
            } else if (angle > 90 && angle < 180) {
                angleType = "OBTUSO"
            } else if (angle == 180.0) {
                angleType = "LLANO"
            } else if (angle > 180 && angle < 360) {
                angleType = "CONCAVO"
            } else {
                angleType = "ERROR"
            }

            resultTextView.text = "Tipo de angulo: ${angleType}"
        }
    }
}
