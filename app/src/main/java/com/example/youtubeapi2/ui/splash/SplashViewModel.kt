package com.example.youtubeapi2.ui.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.youtubeapi2.base.BaseViewModel
import com.example.youtubeapi2.data.repo.Repository
import com.example.youtubeapi2.model.Playlist

class SplashViewModel(private val repo:Repository):BaseViewModel(){
    private val _playlist = MutableLiveData<Playlist>()
    private val _result = MutableLiveData<Boolean>()

    val playlist = _result.switchMap {
        repo.getPlaylist()
    }
    val setPlaylist = _playlist.switchMap {
        repo.setPlayList(it)
    }
    fun getPlaylist(){
        _result.value = true
    }
    fun setPlaylist(playlist: Playlist){
        _playlist.value = playlist
    }

}