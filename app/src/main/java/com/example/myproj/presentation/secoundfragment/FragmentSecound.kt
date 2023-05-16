package com.example.myproj

import com.example.myproj.databinding.FragmentSecondBinding



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide


class FragmentSecond : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val numberInArray = "number"
        const val name = "name"
        const val duration = "duration"
        const val url = "url"
        const val artist = "artist"


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(view).load(arguments?.getString(url)).into(binding.imageView)
        binding.name.text = arguments?.getString(name)
        binding.durationTextView.text = arguments?.getString(duration)
        binding.artisttextview.text = arguments?.getString(artist)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}