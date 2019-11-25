package dev.haenara.catless.view

interface CatApiPublisher {
    fun addObserver(observer: CatApiObserver)
    fun delete(observer: CatApiObserver)
    fun notifyObserver(index: Int = -1)
}

interface CatApiObserver {
    fun update(index: Int)
}