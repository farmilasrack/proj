package com.example.myproj



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class AnimalsAdapters(
    val fragment: FragmentFirst,
    var tracks: ArrayList<Track>, val listner: Listener
) : RecyclerView.Adapter<AnimalsAdapters.AnimalViewHolder>() {

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textViewAnimalName: TextView = itemView.findViewById(R.id.nameOfAnmal)
        var textViewAnimalShortDescription: TextView = itemView.findViewById(R.id.shortDesciption)
        var image: ImageView = itemView.findViewById(R.id.imageAnimal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {

        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.animal_card, parent, false)
        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tracks.size
    }


    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listner.onClick(position)
        }
        Glide.with(fragment)
            .load(tracks.get(position).urlPhoto).fitCenter().into(holder.image)
        holder.textViewAnimalName.text = tracks.get(position).name
        holder.textViewAnimalShortDescription.text = tracks.get(position).album
    }

    interface Listener {
        fun onClick(itemView: Int)
    }
}