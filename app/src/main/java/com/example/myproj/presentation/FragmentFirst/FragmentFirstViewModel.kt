package com.example.myproj.presentation.FragmentFirst

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myproj.Data
import com.example.myproj.models.PlaylistRepository
import com.example.myproj.usecases.TrackServise
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentFirstViewModel : ViewModel() {

    private val usescases= TrackServise()

    val tracks = MutableLiveData<ArrayList<Data>>()

    fun getPlaylistTracks(playlistId:Long=11190694024) {
        viewModelScope.launch {
            val tracksList = withContext(Dispatchers.IO) {
              usescases.getPlaylistTracks(11190694024)
            }
            tracks.value = tracksList
        }
    }
}