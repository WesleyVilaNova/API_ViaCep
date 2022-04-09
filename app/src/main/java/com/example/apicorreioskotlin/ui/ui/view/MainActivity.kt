package com.example.apicorreioskotlin.ui.ui.view

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apicorreioskotlin.R
import com.example.apicorreioskotlin.ui.interfaces.InterfacePresenter
import com.example.apicorreioskotlin.ui.models.ModelConsult
import com.example.apicorreioskotlin.ui.presenter.PresenterAPI as PresenterAPI1

class MainActivity : AppCompatActivity(), InterfacePresenter.ContratoView {

    private lateinit var btn_consultar: Button
    public lateinit var editText_pesquisar: EditText
    private lateinit var textView: TextView
    var string: String = ""

    var view: InterfacePresenter.ObtendoPacote = PresenterAPI1(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciandoComponentes()
        chamandoRetrofit()
        viewApi(string)
    }

    private fun iniciandoComponentes() {
        editText_pesquisar = findViewById(R.id.editText_pesquisar)
        btn_consultar = findViewById(R.id.btn_consultar)
        textView = findViewById(R.id.textView)
    }

    private fun chamandoRetrofit() {
        btn_consultar.setOnClickListener {
            if (editText_pesquisar.length() == 0) {
                editText_pesquisar.setError("Cep inválido")
            } else {
                Log.i("TAG", "Vai consultar a API no presenter")
                view.obtemAPI()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "OnStart", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show()
    }

    override fun editText(editText: EditText?): String? {
        Log.i("TAG", "Chegou do presente para pegar o EditText")
        return editText_pesquisar.text.toString()
    }

    override fun viewApi(textoCep: String) {
        Log.i("TAG", "chegou a resposta do response na activity")
        return textView.setText(textoCep)
    }

    override fun mostrarError() {
        Toast.makeText(this, "Ocorreu um error ao pesquisar", Toast.LENGTH_LONG).show()
    }


}