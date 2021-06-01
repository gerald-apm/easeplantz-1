package com.easeplantz.easeplantz.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.easeplantz.easeplantz.data.main.MainAdapter
import com.easeplantz.easeplantz.data.main.MainViewModel
import com.easeplantz.easeplantz.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory() )[MainViewModel::class.java]
        val menus = viewModel.getMenus()

        val mainAdapter = MainAdapter()
        mainAdapter.setMenus(menus)

        activityMainBinding.apply {
            rv_plants.layoutManager = LinearLayoutManager(this@MainActivity)
            rv_plants.setHasFixedSize(true)
            rv_plants.adapter = mainAdapter
        }



    }
}