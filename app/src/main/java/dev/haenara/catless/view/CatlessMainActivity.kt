package dev.haenara.catless.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import dev.haenara.catless.R
import dev.haenara.catless.config.INITIAL_CATS_NUM
import dev.haenara.catless.databinding.ActivityMainBinding
import dev.haenara.catless.viewmodel.CatViewModel

class CatlessMainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    private val scrollFinishedListener = object : OnScrollFinishedListener {
        override fun onScrollFinished() {
            mBinding.mCatViewModel?.onScrollFinished()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.scrollFinishedListener = scrollFinishedListener
        mBinding.lifecycleOwner = this
        mBinding.mCatViewModel = ViewModelProviders.of(this).get(CatViewModel::class.java)
        repeat(INITIAL_CATS_NUM) { addCat() }
    }

    private fun addCat() {
        mBinding.mCatViewModel?.addCat()
    }
}
