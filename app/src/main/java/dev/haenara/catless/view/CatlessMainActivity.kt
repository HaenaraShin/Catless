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
    lateinit var mCatViewModel: CatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.lifecycleOwner = this
        ViewModelProviders.of(this).get(CatViewModel::class.java)
            .let{
                mBinding.mCatViewModel = it
                it.getCatLivedata().observe(this@CatlessMainActivity, Observer {
                    rcv_cat_list.adapter?.notifyDataSetChanged()

                })
            }

        for (i in 1..10){
            addCat() // TO TEST
        }

    }

    private fun addCat() {
        for (i in 1..3) {
            mBinding.mCatViewModel?.addCat {
                rcv_cat_list.adapter?.notifyDataSetChanged()
            }
        }
    }

}
