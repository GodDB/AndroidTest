package com.godgod.unittest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.godgod.unittest.databinding.ActivityMainBinding
import com.godgod.unittest.db.AppDataBase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            activity = this@MainActivity
            lifecycleOwner = this@MainActivity
            vm = viewModel
        }
    }

    fun onClickNext() {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}
