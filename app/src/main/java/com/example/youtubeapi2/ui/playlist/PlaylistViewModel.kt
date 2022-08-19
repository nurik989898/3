package com.example.youtubeapi2.ui.playlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.youtubeapi2.base.BaseViewModel
import com.example.youtubeapi2.data.repo.Repository
import com.example.youtubeapi2.model.Playlist

class PlaylistViewModel(private val repo:Repository):BaseViewModel() {


    private val _local = MutableLiveData<Boolean>()


    val localPlaylist = _local.switchMap {
        repo.getPlaylist()
    }

    }