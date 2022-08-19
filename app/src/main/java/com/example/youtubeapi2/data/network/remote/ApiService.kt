package com.example.youtubeapi2.data.network.remote

import com.example.youtubeapi2.BuildConfig
import com.example.youtubeapi2.model.Playlist
import com.example.youtubeapi2.utils.Const
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
     suspend fun getPlaylists(
        @Query("part")part: String = Const.PART,
        @Query("channelId") channelId: String = Const.CHANNEL_ID,
        @Query("key")apiKey:String = BuildConfig.API_KEY
    ): Response<Playlist>
}