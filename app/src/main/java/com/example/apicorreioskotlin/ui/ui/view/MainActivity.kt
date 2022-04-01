package com.example.apicorreioskotlin.ui.ui.view

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apicorreioskotlin.R
import com.example.apicorreioskotlin.ui.models.ModelConsult
import com.example.apicorreioskotlin.ui.repository.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var btn_consultar : Button
    private lateinit var editText_pesquisar : EditText
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciandoComponentes()
        chamandoRetrofit()

    }

    private fun iniciandoComponentes() {
        editText_pesquisar = findViewById(R.id.editText_pesquisar)
        btn_consultar = findViewById(R.id.btn_consultar)
        textView = findViewById(R.id.textView)
    }

    private fun chamandoRetrofit() {
        btn_consultar.setOnClickListener {
            val call : Call<ModelConsult?>? = RetrofitConfig()
                .getService
                .buscarCEP(editText_pesquisar.text.toString())

            call?.enqueue(object : Callback<ModelConsult?>{
                override fun onResponse(
                    call: Call<ModelConsult?>,
                    response: Response<ModelConsult?>
                ) {
                    if (response.isSuccessful){
                        var model : ModelConsult? = response.body()
                            textView.setText(model?.TextExibicao())
                            Log.i("Infor","Informação" + response.message())
                            editText_pesquisar.setText("")

                    }
                }

                override fun onFailure(call: Call<ModelConsult?>, t: Throwable) {
                    Log.e("TAG", "****************$t")
                    Toast.makeText(this@MainActivity,"***********************",Toast.LENGTH_LONG)
                }


            })


        }




    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"OnStart",Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"onResume", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"onPause", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"onStop", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"onDestroy", Toast.LENGTH_LONG).show()
    }


}