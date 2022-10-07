package com.feerny.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityHistorial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        val campoMensaje = findViewById<TextView>(R.id.idText)


        var miBundle: Bundle? = this.intent.extras

        if (miBundle != null){
            campoMensaje.text="${miBundle.getString("Operaciones")}"
        }

        val botonSalir:Button=findViewById(R.id.IdBack)
        botonSalir.setOnClickListener { onClick() }
    }

    private fun onClick(){
        finish()
    }
}