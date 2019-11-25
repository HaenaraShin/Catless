package dev.haenara.catless.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.haenara.catless.config.LOAD_MODE_CATS_NUM
import dev.haenara.catless.model.Cat
import dev.haenara.catless.repository.CatRepository
import dev.haenara.catless.view.CatApiObserver
import dev.haenara.catless.view.CatApiPublisher

class CatViewModel :ViewModel(), CatApiPublisher {
    private val mCats = CatRepository.getDataSet()
    private val mObservers = ArrayList<CatApiObserver>()
    fun getCatLivedata(): MutableLiveData<List<Cat>> = mCats

    fun addCat() {
        CatRepository.getNewCat {position -> notifyObserver(position) }
    }

    fun onScrollFinished() {
        repeat(LOAD_MODE_CATS_NUM) { addCat() }
    }

    override fun addObserver(observer: CatApiObserver) {
        mObservers.add(observer)
    }

    override fun delete(observer: CatApiObserver) {
        mObservers.remove(observer)
    }

    override fun notifyObserver(index: Int) {
        mObservers.forEach{ it.update(index) }
    }
}

