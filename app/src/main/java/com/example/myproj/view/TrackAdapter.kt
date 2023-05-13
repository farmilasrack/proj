package com.example.myproj.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myproj.Data
import com.example.myproj.FragmentFirst
import com.example.myproj.R
import kotlin.time.Duration.Companion.seconds


class TrackAdapter(
    private val fragment: FragmentFirst,
    private var tracks: ArrayList<Data>,
    private val listener: Listener
) : RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {

    class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textViewTitle: TextView = itemView.findViewById(R.id.titleTextView)
        var textViewAlbum: TextView = itemView.findViewById(R.id.durationTextView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {

        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_track, parent, false)
        return TrackViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tracks.size
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onClick(position)
        }

        val track = tracks[position]

        holder.textViewTitle.text = track.title
        holder.textViewAlbum.text =  track.duration.seconds.toString()

    }

    fun getItem(position: Int): Data {
        return tracks[position]
    }

    fun updateList(newList: ArrayList<Data>) {
        tracks.clear()
        tracks.addAll(newList)
        notifyDataSetChanged()
    }

    interface Listener {
        fun onClick(position: Int)
    }
}