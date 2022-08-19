package com.example.youtubeapi2.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    private val _local = MutableLiveData<Boolean>()
    fun getLocalPlaylist(){
        _local.value= true
    }

    val progress = MutableLiveData<Boolean>()
}