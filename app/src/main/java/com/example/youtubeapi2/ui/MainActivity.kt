 package com.example.youtubeapi2.ui

import android.view.LayoutInflater
import androidx.navigation.findNavController
import com.example.youtubeapi2.R
import com.example.youtubeapi2.base.BaseActivity
import com.example.youtubeapi2.databinding.ActivityMainBinding

 class MainActivity : BaseActivity<ActivityMainBinding>() {

     override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
         return ActivityMainBinding.inflate(layoutInflater)
     }

     override fun initView() {
    val navController = findNavController(R.id.nav_host_fragment)
    navController.addOnDestinationChangedListener { controller, destination, arguments ->
        if (destination.id == R.id.splashFragment){
            supportActionBar?.hide()
        }else{
            supportActionBar?.show()
        }
    }
     }

     override fun initClickListener() {

     }

 }