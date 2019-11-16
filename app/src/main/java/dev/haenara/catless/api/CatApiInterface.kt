package dev.haenara.catless.api

import dev.haenara.catless.model.Cat
import retrofit2.Call
import retrofit2.http.GET

interface CatApiInterface {
    @GET("v1/images/search")
    fun requestCatImage() : Call<List<Cat>>
}

