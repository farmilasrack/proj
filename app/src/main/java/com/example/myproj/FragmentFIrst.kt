package com.example.myproj

import com.example.myproj.databinding.FragmentFirstBinding



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager



class FragmentFirst : Fragment(), AnimalsAdapters.Listener {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    var tracks = ArrayList<Track>()
    lateinit var adapter: AnimalsAdapters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var cat = Track(
            "Cat",
            "Real little king",
           "https://www.clipartmax.com/png/middle/262-2628268_gfycat-url-animation-dog-walking-gif.png",
          ""
        )
        var dog = Track(
            "Dog",
            "Faithful friend",
          "https://www.clipartmax.com/png/middle/262-2628268_gfycat-url-animation-dog-walking-gif.png" ,
            ""
        )
        var owl = Track(
            "Owl",
            "Symbol of wisdom",
           "https://ca-times.brightspotcdn.com/dims4/default/67694a4/2147483647/strip/false/crop/7958x5577+0+0/resize/1486x1041!/quality/80/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F85%2F44%2F7482a5f343389c5d4c0717c33f09%2Fla-me-snowy-owl-cypress-rare-birdwatching-rr-20221230-1.jpg",
            ""
        )

        tracks.add(cat)
        tracks.add(dog)
        tracks.add(owl)
        adapter = AnimalsAdapters(this, tracks, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.rV.layoutManager = layoutManager
        binding.rV.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(itemView: Int) {
        val bundle = bundleOf(
            FragmentSecond.numberInArray to itemView,
            FragmentSecond.name to tracks.get(itemView).name,
            FragmentSecond.album to tracks.get(itemView).album,
            FragmentSecond.url to tracks.get(itemView).urlPhoto,
            FragmentSecond.allDescription to tracks.get(itemView).allDescription
        )
        findNavController().navigate(R.id.action_fragmentFirst_to_fragmentSecond, bundle)
    }


}