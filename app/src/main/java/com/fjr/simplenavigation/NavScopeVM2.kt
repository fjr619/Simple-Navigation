package com.fjr.simplenavigation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NavScopeVM2 : ViewModel() {
    init {
        getSecondFragmentRequest()
    }

    private fun getSecondFragmentRequest() {
        viewModelScope.launch {
            Log.e("TAG", "vm ${NavScopeVM2::class} getSecondFragmentRequest")
            delay(10000)
            Log.e("TAG", "DONE")
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("TAG","oncleared")
    }
}