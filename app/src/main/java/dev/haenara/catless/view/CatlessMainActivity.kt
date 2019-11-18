package dev.haenara.catless.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import dev.haenara.catless.R
import dev.haenara.catless.databinding.ActivityMainBinding
import dev.haenara.catless.viewmodel.CatViewModel
import kotlinx.android.synthetic.main.activity_main.*

class CatlessMainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.lifecycleOwner = this
        mBinding.mCatViewModel = ViewModelProviders.of(this).get(CatViewModel::class.java)

        for (i in 1..10){
            addCat() // TO TEST
        }

    }

    private fun addCat() {
        mBinding.mCatViewModel?.addCat{
            rcv_cat_list.adapter?.notifyDataSetChanged()
        }
    }

}
