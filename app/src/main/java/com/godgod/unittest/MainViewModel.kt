package com.godgod.unittest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.godgod.unittest.db.AppEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val appDataSource: AppDataSource) : ViewModel() {

    private val _clickState: MutableLiveData<ClickState> = MutableLiveData(ClickState.None())
    val clickState: LiveData<ClickState>
        get() = _clickState

    private val _itemList: MutableLiveData<List<AppEntity>> = MutableLiveData()
    val itemList: LiveData<List<AppEntity>>
        get() = _itemList

    fun onClick() {
        this._clickState.value = ClickState.Complete()
    }

    fun onClickToDB() {
        viewModelScope.launch {
           val result = withContext(Dispatchers.IO) {
                appDataSource.insertAppData(AppEntity(0, "name"))
                appDataSource.getDatas()
            }
            _itemList.value = result
        }
    }

}

sealed class ClickState {

    data class None(val text: Int = R.string.click_none) : ClickState()
    data class Complete(val text: Int = R.string.click_none) : ClickState()

}