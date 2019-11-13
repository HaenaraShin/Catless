package dev.haenara.catless.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.haenara.catless.R

class CatlessMainActivity : AppCompatActivity() {
    // TODO define super class 'Basic Activity'
    // TODO add DataBinding logic
    // TODO add ViewModel
    // TODO create repository to get cats list
    // TODO create ApiService to get cats via TheCatAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
