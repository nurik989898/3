package com.example.youtubeapi2.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.youtubeapi2.data.converter.Converter
import com.example.youtubeapi2.model.Playlist

@Database(entities = [Playlist::class], version = 2)
@TypeConverters(Converter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun dao(): Dao
}