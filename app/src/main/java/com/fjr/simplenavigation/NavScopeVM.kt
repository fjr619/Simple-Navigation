package com.fjr.simplenavigation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

class NavScopeVM : ViewModel() {
    var dataEditText: MutableLiveData<String> = MutableLiveData("")
    var needRequest = true
    var dataRequest2: MutableLiveData<String> = MutableLiveData("")
    init {
        getFirstFragmentRequest()
    }

    fun getFirstFragmentRequest() {
        if (needRequest) {
            Log.e("TAG", "vm ${NavScopeVM::class} getFirstFragmentRequest")
            needRequest = false
        }
    }


}