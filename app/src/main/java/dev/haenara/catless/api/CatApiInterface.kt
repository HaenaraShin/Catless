package dev.haenara.catless.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApiInterface {
    @GET("v1/images/search")
    fun requestCatImage() : Call<List<Cat>>
}

