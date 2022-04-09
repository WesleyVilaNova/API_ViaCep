package com.example.apicorreioskotlin.ui.presenter

import android.util.Log
import android.widget.EditText
import com.example.apicorreioskotlin.ui.interfaces.InterfacePresenter
import com.example.apicorreioskotlin.ui.models.ModelConsult
import com.example.apicorreioskotlin.ui.repository.RetrofitConfig
import com.example.apicorreioskotlin.ui.ui.view.MainActivity

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterAPI( _view : InterfacePresenter.ContratoView) : InterfacePresenter.ObtendoPacote {

    var view: InterfacePresenter.ContratoView = _view

    var texto : String = ""
    var editText : EditText? = null


    override fun obtemAPI() {
        Log.i("TAG" , "Chegou no presenter ")
        val call: Call<ModelConsult?>? = RetrofitConfig()
            .getService
            .buscarCEP(view.editText(editText = editText))
        Log.i("TAG" , "voltou da activity ")
        call?.enqueue(object : Callback<ModelConsult?> {
            override fun onResponse(
                call: Call<ModelConsult?>,
                response: Response<ModelConsult?>
            ) {
                if (response.isSuccessful) {
                    Log.i("TAG" , "Chegou no if do response")
                    var model: ModelConsult? = response.body()
                    texto = (model?.TextExibicao().toString())
                    Log.i("TAG" , "vai passar para activity o response ")
                    view.viewApi(textoCep = texto)
                    Log.i("TAG" , "já enviou")
                } else {
                    view.mostrarError()
                }
            }

            override fun onFailure(call: Call<ModelConsult?>, t: Throwable) {
                view.mostrarError()
            }

        })
    }

}