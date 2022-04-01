package com.example.apicorreioskotlin.ui.repository

import com.example.apicorreioskotlin.ui.interfaces.Webservice
import com.example.apicorreioskotlin.ui.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitConfig {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    val getService : Webservice by lazy {
        retrofit.create(Webservice::class.java)
    }
}