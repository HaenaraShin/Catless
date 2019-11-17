package dev.haenara.catless.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dev.haenara.catless.R
import dev.haenara.catless.databinding.ActivityMainBinding
import dev.haenara.catless.viewmodel.CatViewModel

class CatlessMainActivity : AppCompatActivity() {
    // TODO create repository to get cats list
    // TODO create ApiService to get cats via TheCatAPI

    lateinit var mCatViewModel: CatViewModel
    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.lifecycleOwner = this

        mCatViewModel = ViewModelProviders.of(this).get(CatViewModel::class.java)
    }
}
