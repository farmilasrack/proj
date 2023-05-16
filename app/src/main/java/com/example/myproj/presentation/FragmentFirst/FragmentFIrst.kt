package com.example.myproj

import com.example.myproj.presentation.FragmentFirst.TrackAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproj.databinding.FragmentFirstBinding
import com.example.myproj.presentation.FragmentFirst.FragmentFirstViewModel
import kotlin.time.Duration.Companion.seconds

class FragmentFirst : Fragment(), TrackAdapter.Listener {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FragmentFirstViewModel by viewModels()

    lateinit var adapter: TrackAdapter

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
        adapter = TrackAdapter(this, ArrayList<Data>()
            , this)
        binding.rV.layoutManager = layoutManager
        binding.rV.adapter = adapter

        viewModel.tracks.observe(viewLifecycleOwner) { tracks ->
            adapter.updateList(tracks)
        }

        viewModel.getPlaylistTracks(11190694024)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(itemView: Int) {
        val track = adapter.getItem(itemView)
        val bundle = Bundle().apply {
            putInt(FragmentSecond.numberInArray, itemView)
            putString(FragmentSecond.name, track.title)
            putString(FragmentSecond.duration, track.duration.seconds.toString())
            putString(FragmentSecond.url, track.album.cover)
            putString(FragmentSecond.artist, track.artist.name)
        }
        findNavController().navigate(R.id.action_fragmentFirst_to_fragmentSecond, bundle)
    }
}