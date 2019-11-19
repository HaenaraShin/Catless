package dev.haenara.catless.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.haenara.catless.model.Cat
import dev.haenara.catless.repository.CatRepository
import dev.haenara.catless.view.OnScrollFinishedListener

class CatViewModel :ViewModel(){
    private val mCats = CatRepository.getDataSet()
    public fun getCatLivedata(): MutableLiveData<List<Cat>> = mCats

    val scrollFinishedListener = object: OnScrollFinishedListener {
        override fun onScrollFinished() {
            addCat {  }
        }
    }

    fun addCat(callback: ()-> Unit) {
        CatRepository.getNewCat(callback)
    }

}