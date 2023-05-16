package com.example.myproj.usecases

import com.example.myproj.Data
import com.example.myproj.TracksResponse
import com.example.myproj.models.PlaylistRepository

class TrackServise  {
private val repository=PlaylistRepository()
    suspend fun getPlaylistTracks(playlistId: Long): ArrayList<Data> {
        val response =repository.getPlaylistTracks(11190694024)
        return if (response!=null) {
            response
        } else {
            ArrayList<Data>()
        }
    }
}