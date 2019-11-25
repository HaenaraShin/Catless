package dev.haenara.catless.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.haenara.catless.R
import dev.haenara.catless.databinding.ViewItemCatBinding
import dev.haenara.catless.model.Cat
import dev.haenara.catless.viewmodel.CatViewModel

class CatListAdapter(
    private val cats: List<Cat>
) : RecyclerView.Adapter<CatListAdapter.ViewHolder>(),
    CatApiObserver {
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
            mBinding.cat = item
        }
    }

    override fun update(index: Int) {
        if (index < 0) {
            notifyDataSetChanged()
        } else {
            notifyItemChanged(index)
        }
    }
}

@BindingAdapter("recyclerViewBindingAdapter")
fun setRecyclerViewBindingAdapter(view: RecyclerView, viewModel: CatViewModel) {
    if (view.adapter == null) {
        view.adapter = CatListAdapter(viewModel.getCatLivedata().value as List<Cat>)
            .apply { viewModel.addObserver(this) }
    }
    view.adapter?.notifyDataSetChanged()
}

@BindingAdapter("catId")
fun setCatId(view: TextView, cat: Cat) {
    view.text = cat.id
}


@BindingAdapter("catImage")
fun setCatImage(view: ImageView, cat: Cat) {
    view.setImageFromUrl(view.context, cat.url)
    view.setOnClickListener {
        Toast.makeText(view.context, cat.id, Toast.LENGTH_SHORT).show()
    }
}

private fun ImageView.setImageFromUrl(context: Context, url: String) {
    Glide.with(context)
        .asBitmap()
        .load(url)
        .centerCrop()
        .thumbnail()
        .into(this)
}
