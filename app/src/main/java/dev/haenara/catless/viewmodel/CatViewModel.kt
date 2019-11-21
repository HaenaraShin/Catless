package dev.haenara.catless.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.haenara.catless.config.LOAD_MODE_CATS_NUM
import dev.haenara.catless.model.Cat
import dev.haenara.catless.repository.CatRepository

class CatViewModel :ViewModel(){
    private val mCats = CatRepository.getDataSet()
    public fun getCatLivedata(): MutableLiveData<List<Cat>> = mCats

    fun addCat(callback: (position: Int)-> Unit) {
        CatRepository.getNewCat(callback)
    }

    fun onScrollFinished(callback: (position: Int) -> Unit) {
        repeat(LOAD_MODE_CATS_NUM) { addCat(callback) }
    }

}