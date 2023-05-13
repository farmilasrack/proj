package com.example.myproj.models


import com.example.myproj.Data
import com.example.myproj.Track
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlaylistRepository {

  private val deezerApiService: DeezerApiService by lazy {
    val retrofit = Retrofit.Builder()
      .baseUrl("https://api.deezer.com/")
      .addConverterFactory(GsonConverterFactory.create())
      .client(OkHttpClient())
      .build()
    retrofit.create(DeezerApiService::class.java)
  }

  suspend fun getPlaylistTracks(playlistId: Long): ArrayList<Data> {
    val response = deezerApiService.getPlaylistTracks(playlistId)
    return if (response.isSuccessful) {
      response.body()?.data?:  ArrayList<Data>()
    } else {
      ArrayList<Data>()
    }
  }

}