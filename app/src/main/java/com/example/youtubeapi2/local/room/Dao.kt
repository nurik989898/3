package com.example.youtubeapi2.local.room


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.youtubeapi2.model.Playlist

@Dao
interface Dao {

    @Insert(onConflict = REPLACE)
    fun insert(playlist: Playlist)

    @Insert
    fun insertAll(playlist: List<Playlist>)

    @Query("SELECT * FROM playlist ")
    fun getAll(): Playlist

}