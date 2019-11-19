package dev.haenara.catless.view

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

interface OnScrollFinishedListener {
    fun onScrollFinished()
}

@BindingAdapter("scrollFinishedListener")
fun setScrollFinishedListener(view: RecyclerView, listener:OnScrollFinishedListener) {
    view.addOnScrollListener(object: RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            if (dy > 0 && !recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN)) {
                listener.onScrollFinished()
            }
        }
    })
}
