package com.example.apicorreioskotlin.ui.interfaces

import com.example.apicorreioskotlin.ui.models.ModelConsult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Webservice {

    @GET ("{cep}/json/")
    fun buscarCEP(@Path("cep") cep: String?): Call<ModelConsult?>?

}