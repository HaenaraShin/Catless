package dev.haenara.catless.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.haenara.catless.R
import dev.haenara.catless.databinding.ViewItemCatBinding
import dev.haenara.catless.model.Cat

class CatListAdapter : RecyclerView.Adapter<CatListAdapter.ViewHolder>() {
    private val cats = mutableListOf<Cat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.view_item_cat, parent, false
        )
    )

    override fun getItemCount(): Int = cats.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cats[position])
    }

    inner class ViewHolder(
        private val mBindinding: ViewItemCatBinding
    ) : RecyclerView.ViewHolder(mBindinding.root) {

        fun bind(item: Cat) {
            mBindinding.run {
                ivCatImage.setImageFromUrl(item.url)
                tvCatId.text = item.id
            }
        }

        fun ImageView.setImageFromUrl(url: String) {
            Glide.get(mBindinding.root.context)

        }


    }
}