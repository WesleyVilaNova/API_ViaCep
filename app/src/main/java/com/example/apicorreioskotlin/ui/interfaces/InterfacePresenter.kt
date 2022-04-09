package com.example.apicorreioskotlin.ui.interfaces

import android.widget.EditText
import com.example.apicorreioskotlin.ui.models.ModelConsult

interface InterfacePresenter {

    interface ObtendoPacote {
        fun obtemAPI()
    }

    interface ContratoView {
        fun editText(editText: EditText?): String?
        fun viewApi(textoCep: String)
        fun mostrarError()
    }
}