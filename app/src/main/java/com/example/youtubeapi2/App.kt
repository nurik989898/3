package com.example.youtubeapi2

import android.app.Application
import androidx.room.Room
import com.example.youtubeapi2.local.room.AppDataBase

class App: Application(){
   companion object{
        lateinit var db:AppDataBase
    }
   override fun onCreate() {
       super.onCreate()
       db = Room.databaseBuilder(applicationContext,AppDataBase::class.java,"database")
           .build()
    }
}