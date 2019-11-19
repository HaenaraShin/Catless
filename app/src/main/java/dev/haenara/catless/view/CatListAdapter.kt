package dev.haenara.catless.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.haenara.catless.R
import dev.haenara.catless.databinding.ViewItemCatBinding
import dev.haenara.catless.model.Cat

class CatListAdapter(
    private val cats : List<Cat>
) : RecyclerView.Adapter<CatListAdapter.ViewHolder>() {

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
        private val mBinding: ViewItemCatBinding
    ) : RecyclerView.ViewHolder(mBinding.root) {

        fun bind(item: Cat) {
            mBinding.run {
                ivCatImage.setImageFromUrl(item.url)
                tvCatId.text = item.id
                ivCatImage.setOnClickListener {
                    // TODO show Cat Image Dialog
                    Toast.makeText(mBinding.root.context, item.id, Toast.LENGTH_SHORT).show()
                }
            }
        }

        private fun ImageView.setImageFromUrl(url: String) {
            Glide.with(mBinding.root.context)
                .asBitmap()
                .load(url)
                .centerCrop()
                .into(this)
        }
    }
}

@BindingAdapter("recyclerViewBindingAdapter")
fun setRecyclerViewBindingAdapter(view: RecyclerView, cats: MutableLiveData<List<Cat>>) {
    if (view.adapter == null) {
        view.adapter = CatListAdapter(cats.value as List<Cat>)
    }
    view.adapter?.notifyDataSetChanged()
}
