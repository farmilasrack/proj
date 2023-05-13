package com.example.myproj

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myproj.models.PlaylistRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentFirstViewModel : ViewModel() {

    private val playlistRepository = PlaylistRepository()

    val tracks = MutableLiveData<ArrayList<Data>>()

    fun getPlaylistTracks(playlistId:Long=11190694024) {
        viewModelScope.launch {
            val tracksList = withContext(Dispatchers.IO) {
                playlistRepository.getPlaylistTracks(playlistId)
            }
            tracks.value = tracksList
        }
    }
}