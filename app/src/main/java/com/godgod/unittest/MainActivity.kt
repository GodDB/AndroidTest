package com.godgod.unittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.godgod.unittest.databinding.ActivityMainBinding
import com.godgod.unittest.db.AppDataBase

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this, ViewModelFactory())[MainViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            lifecycleOwner = this@MainActivity
            vm = viewModel
        }
    }

    inner class ViewModelFactory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            //TODO hilt 추가하자
            return MainViewModel(AppDataSourceImpl(AppDataBase.createInMemory(applicationContext).getDao())) as T
        }
    }
}
