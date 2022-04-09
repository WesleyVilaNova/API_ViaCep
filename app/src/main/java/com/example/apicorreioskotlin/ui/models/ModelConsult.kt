package com.example.apicorreioskotlin.ui.models

import com.squareup.moshi.Json

data class ModelConsult(
    val cep : String,

    @Json (name = "logradouro")
    val logradouro : String,

    val complemento : String,
    val bairro : String,
    val localidade : String,



) {
    fun TextExibicao(): String {
        return "Endereço: $logradouro\n" +
                " Cidade: $localidade\n" +
                " Bairro: $bairro\n" +
                "\n"+
                "Seu CEP de consulta: $cep\n" +
                "\n"+
                "\n"+
                "Testando API com MVP \n100% Kotlin"
    }
}

