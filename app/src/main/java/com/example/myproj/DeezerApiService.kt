package com.example.myproj.models


import com.example.myproj.TracksResponse
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Path

interface DeezerApiService {

    @GET("playlist/{playlistId}/tracks")
    suspend fun getPlaylistTracks(@Path("playlistId") playlistId: Long): Response<TracksResponse>

}
