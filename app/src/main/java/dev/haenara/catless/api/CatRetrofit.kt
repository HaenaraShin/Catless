package dev.haenara.catless.api

import dev.haenara.catless.config.THE_CAT_API_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CatRetrofit {
    private val retrofit = Retrofit.Builder()
        .baseUrl(THE_CAT_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getService() = retrofit.create(CatApiInterface::class.java)
}