package com.godgod.unittest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.godgod.unittest.databinding.ActivityMain2Binding
import com.godgod.unittest.databinding.ViewholderTestBinding
import com.godgod.unittest.db.AppDataBase
import com.godgod.unittest.db.AppEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity2 : AppCompatActivity() {

    private val binding: ActivityMain2Binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    private val viewModel by viewModels<Main2ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            lifecycleOwner = this@MainActivity2
            vm = viewModel
        }

        binding.rv.adapter = Adapter(
            onClickBtn1 = {
                viewModel.onClickBtn1(it)
            },
            onClickBtn2 = {
                viewModel.onClickBtn2(it)
            }
        )

        viewModel.items.observe(this) {
            (binding.rv.adapter as Adapter).set(it)
        }
    }
}

class Adapter(private val onClickBtn1: (data : AppEntity) -> Unit, private val onClickBtn2: (data : AppEntity) -> Unit) : RecyclerView.Adapter<TestViewHolder>() {

    private val items: MutableList<AppEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val binding = ViewholderTestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TestViewHolder(binding, onClickBtn1, onClickBtn2)
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun set(items : List<AppEntity>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

}

class TestViewHolder(private val binding: ViewholderTestBinding, private val onClickBtn1: (data : AppEntity) -> Unit, private val onClickBtn2: (data : AppEntity) -> Unit) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.testBtn1.setOnClickListener { onClickBtn1(binding.data ?: return@setOnClickListener) }
        binding.testBtn2.setOnClickListener { onClickBtn2(binding.data ?: return@setOnClickListener) }
    }

    fun bind(appEntity: AppEntity) {
        binding.data = appEntity
        binding.executePendingBindings()
    }
}