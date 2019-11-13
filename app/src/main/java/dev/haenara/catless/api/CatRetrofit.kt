package dev.haenara.catless.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CatRetrofit {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getService() = retrofit.create(CatApiInterface::class.java)
}