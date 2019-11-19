package dev.haenara.catless.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import dev.haenara.catless.api.CatRetrofit
import dev.haenara.catless.model.Cat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object CatRepository {
    private val TAG = "Catless::CatRepository"
    private val dataSet = ArrayList<Cat>()

    fun getDataSet(): MutableLiveData<List<Cat>> {
        val data = MutableLiveData<List<Cat>>()
        data.value = dataSet
        return data
    }

    fun getNewCat(callback: ()-> Unit){
        Log.d("NEWCAT", "getting new cat")
        getCat(object: CatReceivedCallback{
            override fun onCatReceived(cat: Cat?) {
                cat?.let {
                    dataSet.add(it)
                    callback()
                }
            }
        })
    }

    private fun getCat(callback: CatReceivedCallback){
        CatRetrofit.getService().requestCatImage().enqueue(object:
            Callback<List<Cat>> {
            override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                Log.e(TAG, t.message ?: "error occured.")
            }

            override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                response.body()?.get(0)?.let {
                    callback.onCatReceived(it)
                }
            }
        })
    }
}

interface CatReceivedCallback {
    fun onCatReceived(cat: Cat?)
}