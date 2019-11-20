package dev.haenara.catless.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dev.haenara.catless.R
import dev.haenara.catless.databinding.ActivityMainBinding
import dev.haenara.catless.viewmodel.CatViewModel
import kotlinx.android.synthetic.main.activity_main.*

class CatlessMainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    private val scrollFinishedListener = object : OnScrollFinishedListener {
        override fun onScrollFinished() {
            mBinding.mCatViewModel?.onScrollFinished { position ->
                notifyItemChange(position)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.scrollFinishedListener = scrollFinishedListener
        mBinding.lifecycleOwner = this
        mBinding.mCatViewModel = ViewModelProviders.of(this).get(CatViewModel::class.java)
        repeat(10) { addCat() }
    }

    private fun addCat() {
        mBinding.mCatViewModel?.addCat { position ->
            notifyItemChange(position)
        }
    }

    private fun notifyItemChange(position: Int){
        rcv_cat_list.adapter?.notifyItemChanged(position)
    }
}
