package com.example.youtubeapi2.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtubeapi2.App
import com.example.youtubeapi2.data.network.remote.RetrofitClient
import com.example.youtubeapi2.domain.Resource
import com.example.youtubeapi2.model.ErrorResponse
import com.example.youtubeapi2.model.Playlist
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers


class Repository {
private val apiService = RetrofitClient.create()

     fun getPlaylist(): LiveData<Resource<Playlist?>> = liveData (Dispatchers.IO){
         emit(Resource.loading())
         val result = apiService.getPlaylists()
        if (result.isSuccessful){
            emit(Resource.success(result.body()))
        }else{
            val jObjError = result.errorBody()?.string()
            val gson = Gson()
            val data = gson.fromJson(jObjError,ErrorResponse::class.java)
            emit(Resource.error(data.errorBody?.message.toString()))
        }
    }
    fun getLocalPlaylist(): LiveData<Resource<Playlist?>> = liveData (Dispatchers.IO){
        emit(Resource.loading())
        val result = App.db.dao().getAll()
            emit(Resource.success(result))
    }
    fun setPlayList(playlist: Playlist):LiveData<Resource<Boolean>> = liveData(Dispatchers.IO){
        App.db.dao().insert(playlist)
        emit(Resource.success(true))
    }
}