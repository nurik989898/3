package com.example.youtubeapi2.ui.playlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi2.App
import com.example.youtubeapi2.base.BaseFragment
import com.example.youtubeapi2.databinding.FragmentPlaylistBinding
import com.example.youtubeapi2.domain.Resource
import com.example.youtubeapi2.ui.adapters.PlaylistAdapter

class PlaylistFragment : BaseFragment<FragmentPlaylistBinding, PlaylistViewModel>() {

    private lateinit var adapter: PlaylistAdapter

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentPlaylistBinding {
        return FragmentPlaylistBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        viewModel.getLocalPlaylist()
            viewModel.localPlaylist.observe(viewLifecycleOwner){
                if (it.status == Resource.Status.SUCCESS){
                    adapter = it.data?.let { it1 -> PlaylistAdapter(it1) }!!
                    binding.recyclerPlaylist.adapter = adapter
                }
            }

        /* val data = App.db.dao().getAll()
         adapter = PlaylistAdapter(data)
         binding.recyclerPlaylist.adapter = adapter
         viewModel.progress.observe(viewLifecycleOwner) {
             binding.progress.isVisible = it
         }*/

    }

    override fun initListener() {

    }

    override fun launchObserve() {

    }


}