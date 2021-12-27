package com.godgod.unittest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.godgod.unittest.db.AppEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Main2ViewModel @Inject constructor(private val appDataSource: AppDataSource) : ViewModel() {

    private val _items: MutableLiveData<List<AppEntity>> = MutableLiveData()
    val items: LiveData<List<AppEntity>>
        get() = _items

    private val _clickBtn1 : MutableLiveData<Boolean> = MutableLiveData(false)
    val clickBtn1 : LiveData<Boolean>
    get() = _clickBtn1

    private val _clickBtn2 : MutableLiveData<Boolean> = MutableLiveData(false)
    val clickBtn2 : LiveData<Boolean>
        get() = _clickBtn2

    init {
        viewModelScope.launch {
            _items.value = appDataSource.getDatas()
        }
    }

    fun onClickBtn1() {
        _clickBtn1.value = true
    }

    fun onClickBtn2() {
        _clickBtn2.value = true
    }
}
