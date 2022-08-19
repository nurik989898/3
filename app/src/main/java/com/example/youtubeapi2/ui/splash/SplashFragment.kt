package com.example.youtubeapi2.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.youtubeapi2.R
import com.example.youtubeapi2.base.BaseFragment
import com.example.youtubeapi2.databinding.FragmentSplashBinding
import com.example.youtubeapi2.domain.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment :BaseFragment<FragmentSplashBinding,SplashViewModel>() {
    override val viewModel: SplashViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(inflater, container, false)
    }


    override fun initView() {
        viewModel.getPlaylist()
        viewModel.playlist.observe(viewLifecycleOwner, {
            viewModel.getPlaylist()
            viewModel.playlist.observe(viewLifecycleOwner) {
                println("333")
                viewModel.progress.value = it.status == Resource.Status.LOADING
                when (it.status) {
                    Resource.Status.SUCCESS -> {
                        Log.d("ololo", "initView ${it.data}")
                        it.data?.let { it1 -> viewModel.setPlaylist(it1) }
                        //it.data.let{ it1 ->App.db.dao().insert(it1) }
                    }
                    Resource.Status.ERROR -> {

                    }
                    else -> {

                    }
                }
            }


            viewModel.setPlaylist.observe(viewLifecycleOwner) {
            if (it.status == Resource.Status.SUCCESS && it.data == true) {
                Handler(Looper.getMainLooper()).postDelayed({
                    findNavController().navigate(R.id.action_splashFragment_to_playlistFragment)
                }, 1000)
            }
        }
    }


    override fun initListener() {

    }

    override fun launchObserve() {

    }
    }





