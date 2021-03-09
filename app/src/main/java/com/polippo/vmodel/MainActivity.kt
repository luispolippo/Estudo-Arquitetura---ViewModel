package com.polippo.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var etContador: EditText
    lateinit var btnDados: Button
    lateinit var btnMostrar: Button

     var mViewModel = MainViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDados()
        initClick()

    }

    private fun initDados() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        etContador = findViewById(R.id.et_contador)
        btnDados = findViewById(R.id.btn_dados)
        btnMostrar = findViewById(R.id.btn_mostrar)

        mViewModel.mContador.observe(this, Observer { valor ->
            etContador.setText(valor)
        })

    }


    private fun initClick() {
        btnDados.setOnClickListener {
            mViewModel.contador()

        }
        btnMostrar.setOnClickListener {
            Toast.makeText(this, "Contador: ${mViewModel.mContador.value}", Toast.LENGTH_SHORT).show()
        }
    }


}